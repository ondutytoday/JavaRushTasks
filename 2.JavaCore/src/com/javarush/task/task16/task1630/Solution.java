package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = readerName.readLine();
            secondFileName = readerName.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String filename;
        private StringBuffer string = new StringBuffer("");;

        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return string.toString();
        }

        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))){

                while (reader.ready()) {
                    string.append(reader.readLine()).append(" ");
                }

            } catch (IOException e) {
                System.out.println("File not found");
            }


        }
    }
}
