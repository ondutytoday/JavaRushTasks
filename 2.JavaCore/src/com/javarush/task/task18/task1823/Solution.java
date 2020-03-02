package com.javarush.task.task18.task1823;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        while (!(line = sc.nextLine()).equals("exit")) {
            ReadThread thread = new ReadThread(line);
            thread.start();
            //thread.readByteFromFile();
        }
        sc.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            readByteFromFile();
        }

        public synchronized void readByteFromFile () {

            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
                int [] bytes = new int [256];
                int maxCountOfByte = -1;
                int byteToFind = -1;
                int b;
                while ((b = in.read()) != -1) {
                    bytes[b] +=1;
                }
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] > maxCountOfByte) {
                        byteToFind = i;
                        maxCountOfByte = bytes[i];
                    }
                }
                byte temp = (byte) byteToFind;
                resultMap.put(fileName, (int) temp);
            } catch (IOException e) {
                System.out.println("File not found");

            }
        }

        //Как найти самый частый элемент в массиве - еще вариант
        /*public void run() {
            int element = list.get(0);
            for (Integer x : list) if (Collections.frequency(list, x) > Collections.frequency(list, element)) element = x;
            resultMap.put(fileName, element);
        }*/

    }
}
