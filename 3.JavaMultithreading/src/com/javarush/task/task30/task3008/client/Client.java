package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Interrupted error" + e.getMessage());
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\n" +
                    "Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        String msg = "";
        while (clientConnected && !"exit".equals(msg)) {
            msg = ConsoleHelper.readString();
            if (shouldSendTextFromConsole()) sendTextMessage(msg);
        }
    }

    protected String getServerAddress() {
        String address = "";
        ConsoleHelper.writeMessage("Enter server-address (ip or localhost:");
        /*do {
            address = ConsoleHelper.readString();
        } while (!address.equals("localhost") || !address.matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$"));*/
        address = ConsoleHelper.readString();
        return address;
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server-port:");
        int port = ConsoleHelper.readInt();
        return port;
    }

    protected String getUserName () {
        ConsoleHelper.writeMessage("Enter your name:");
        String name = ConsoleHelper.readString();
        return name;
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage (String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("An Error occurred" + e.getMessage());
        }

    }

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser (String userName) {
            ConsoleHelper.writeMessage(userName + " connected to chat.");
        }

        protected void informAboutDeletingNewUser (String userName) {
            ConsoleHelper.writeMessage(userName + " has left chat.");
        }

        protected void notifyConnectionStatusChanged (boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }
}
