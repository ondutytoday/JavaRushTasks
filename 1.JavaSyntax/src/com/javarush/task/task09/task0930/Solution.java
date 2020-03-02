package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        /*list.add("Вишня");
        list.add("1");
        list.add("Боб");
        list.add("3");
        list.add("Яблоко");
        list.add("22");
        list.add("0");
        list.add("Арбуз");*/
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        List<Integer> ints = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                ints.add(Integer.parseInt(array[i]));
            } else {
                strings.add(array[i]);
            }
        }
        Collections.sort(ints);
        Collections.reverse(ints);

        String[] string = strings.toArray(new String[strings.size()]);
        boolean isSorted = false;
        String buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < string.length - 1; i++) {
                if (isGreaterThan(string[i], string[i + 1])) {
                    isSorted = false;

                    buf = string[i];
                    string[i] = string[i + 1];
                    string[i + 1] = buf;
                }
            }
        }
        strings.clear();
        for (int i = 0; i < string.length; i++) {
            strings.add(string[i]);
        }


        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = ints.get(0).toString();
                ints.remove(0);
            } else {
                array[i] = strings.get(0);
                strings.remove(0);
            }
        }

    }


    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
