package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

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

    }
}
