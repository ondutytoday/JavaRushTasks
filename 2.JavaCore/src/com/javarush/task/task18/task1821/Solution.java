package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/


import java.io.*;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedReader =
                new BufferedInputStream(new FileInputStream(args[0]));
        int[] count = new int[128];
        byte [] buf = new byte[bufferedReader.available()];
        int countBuf = bufferedReader.read(buf);

        for (int i = 0; i < buf.length; i++) {
            count[(int) buf[i]] += 1;
        }
        for (int i = 0; i < 128; i++) {
            if (count[i] != 0) System.out.println((char) i + " " + count[i]);
        }

        /*StringBuilder string = new StringBuilder();
        while (bufferedReader.ready()) {
            string.append(bufferedReader.readLine());
        }
        char[] array = string.toString().toCharArray();

        for (int i = 0; i < array.length; i++) {
            count[(int) array[i]] += 1;
        }
        for (int i = 0; i < 128; i++) {
            if (count[i] != 0) System.out.println((char) i + " " + count[i]);
        }*/

        bufferedReader.close();

    }
}
