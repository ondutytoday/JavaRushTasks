package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        StringBuilder string = new StringBuilder();
        while (bufferedReader.ready()) {
            string.append(bufferedReader.readLine());
        }
        int countOfSymbols = string.length();
        int countOfSpaces = 0;
        for (int i = 0; i < string.length() ; i++) {
            if (string.charAt(i) == ' ') countOfSpaces++;
        }
        double result = (double)countOfSpaces/(double) countOfSymbols*100;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println(df.format(result));
        bufferedReader.close();
    }
}
