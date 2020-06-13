package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String s = args[0].toUpperCase();
            if (s.matches("[A-Z0-9]+")) {
                char[] chars = s.toCharArray();
                Set<Character> set = new HashSet<>();
                for (char ch : chars) {
                    set.add(ch);
                }
                Character ch = Collections.max(set);
                if (Character.isDigit(ch)) {
                    int n = Integer.parseInt(ch.toString());
                    if (n == 0) System.out.println("2");
                    else System.out.println(n + 1);
                } else {
                    int n = ch - 54;
                    System.out.println(n);
                }
            } else {
                System.out.println("incorrect");
            }
        } catch (Exception e) {
//e.printStackTrace();
        }


    }
}