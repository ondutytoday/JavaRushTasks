package com.javarush.task.task22.task2203;


/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws Exception {
        try {
            String [] array = string.split("\t");
            if (array.length < 3) throw new TooShortStringException();
            return array[1];
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
