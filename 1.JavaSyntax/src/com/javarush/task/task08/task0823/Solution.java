package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] chars = string.toCharArray();
        if (Character.isLetter(chars[0])) chars[0] = Character.toUpperCase(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (Character.isLetter(chars[i]) && Character.isSpaceChar(chars[i - 1])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        System.out.println(chars);
    }
}
