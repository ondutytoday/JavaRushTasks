package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        ArrayList <String> wordsArray = new ArrayList<>(Arrays.asList(words));
        Map<String, List<String>> wordsMap = new HashMap<>();
        for (String word : words ) {
            wordsMap.put(word, new ArrayList<>());
        }
        for (Map.Entry <String, List<String>> entry : wordsMap.entrySet()) {
            for (String word: wordsArray) {
                String ch1 = String.valueOf(entry.getKey().charAt(entry.getKey().length()-1));
                String ch2 = String.valueOf(word.charAt(0));
                if (ch1.equalsIgnoreCase(ch2)) {
                    entry.getValue().add(word);
                }
            }
        }

        return null;
    }
     public static List<String> graph (Map <String, List<String>> map) {

        return null;
     }

}

    /*StringBuilder result = new StringBuilder();
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
        if (result.length() > 0) result.deleteCharAt(result.length()-1);*/