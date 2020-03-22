package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileReader.readLine();
        BufferedReader readerFromFile = new BufferedReader(new FileReader(/*"1.txt"*/ fileName));
        StringBuilder stringFromFile = new StringBuilder();
        while (readerFromFile.ready()) {
            stringFromFile.append(readerFromFile.readLine()).append(" ");
        }

        StringBuilder result = getLine(stringFromFile.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        ArrayList <String> wordsArray = new ArrayList<>(Arrays.asList(words));
        //Collections.sort(wordsArray);
        int i = 0;
        while (wordsArray.size() > 0) {
            String ch = String.valueOf(result.append(wordsArray.get(i)).charAt(result.length()-1));
            wordsArray.remove(i);
            result.append(" ");
            for (int j = 0; j < wordsArray.size(); j++) {
                if (ch.equalsIgnoreCase(String.valueOf(wordsArray.get(j).charAt(0)))) {
                    i = j;
                    continue;
                }
            }
        }
        if (result.length() > 0) result.deleteCharAt(result.length()-1);

        return result;
    }
}
