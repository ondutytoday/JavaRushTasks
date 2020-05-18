package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Введите номер порта сервера:");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен.");
            while (true) {
                try (Socket clientSocket = serverSocket.accept()){
                    Handler handler = new Handler(clientSocket);
                    handler.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                            connection.send(new Message(MessageType.TEXT, "Сообщение не отправлено.\n" + e.getMessage()));
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

        private String serverHandshake (Connection connection) throws IOException, ClassNotFoundException{
            Message clientName = null;
            boolean isCorrectName = false;
            while (!isCorrectName) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                ConsoleHelper.writeMessage("Please enter your name:");
                clientName = connection.receive();
                if (clientName.getType().equals(MessageType.USER_NAME)) {
                    if (clientName.getData().equals("") || clientName.getData() == null) continue;
                    if (connectionMap.containsKey(clientName.getData())) {
                        ConsoleHelper.writeMessage("Failed to register. Username already exists.");
                        continue;
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
    }
}
