package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter number of port:");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started.");
            while (true) {
                try {
                    clientSocket = serverSocket.accept();
                    Handler handler = new Handler(clientSocket);
                    handler.start();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("error with handler");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (clientSocket !=null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        connectionMap.values()
                .parallelStream()
                .forEach(connection -> {
                    try {
                        connection.send(message);
                    } catch (IOException e) {
                        try {
                            connection.send(new Message(MessageType.TEXT, "Error\n" + e.getMessage()));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
/*        for (ConcurrentHashMap.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                try {
                    entry.getValue().send(new Message(MessageType.TEXT, "Сообщение не отправлено.\n"  + e.getMessage()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }*/
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String userName = null;
            ConsoleHelper.writeMessage("Connection successful " + socket.getRemoteSocketAddress());
            Connection connection = null;
            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while exchanging data with the remote address " + e.getMessage());
                try {
                    connection.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message clientName = null;
            boolean isCorrectName = false;
            while (!isCorrectName) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Please enter your name:"));
                clientName = connection.receive();
                if (clientName.getType().equals(MessageType.USER_NAME)) {
                    if (clientName.getData().equals("")) continue;
                    if (connectionMap.containsKey(clientName.getData())) {
                        ConsoleHelper.writeMessage("Failed to register. Username already exists.");
                    } else {
                        connectionMap.put(clientName.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        ConsoleHelper.writeMessage(clientName.getData() + " registered successfully");
                        isCorrectName = true;
                    }
                }
            }
            return clientName.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            connectionMap
                    .forEach((k, v) -> {
                        if (!k.equals(userName)) {
                            try {
                                connection.send(new Message(MessageType.USER_ADDED, k));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message msg = connection.receive();
                if (MessageType.TEXT.equals(msg.getType())) {
                    //нормально завершет по выходу
                   // if (msg.getData().equals("exit")) break;
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + msg.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }

            }
        }
    }
}
