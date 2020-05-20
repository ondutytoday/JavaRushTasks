package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient= new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random()*100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            System.out.println(message);
            if (message != null && message.contains(": ")) {
                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = null;
                String[] strings = message.split(": ");
                boolean isCorrect = false;
                switch (strings[1]) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        isCorrect = true;
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        isCorrect = true;
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        isCorrect = true;
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        isCorrect = true;
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat( "H:mm:ss");
                        isCorrect = true;
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        isCorrect = true;
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        isCorrect = true;
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        isCorrect = true;
                        break;
                }
                if (isCorrect) {
                    message = "Информация для " + strings[0] + ": " + dateFormat.format(date);
                    sendTextMessage(message);
                }
            }
        }
    }
}
