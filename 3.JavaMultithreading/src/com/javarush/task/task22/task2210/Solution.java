package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        /*String [] s = getTokens("level22.lesson13.task01", ".");
        for (String ss : s) {
            System.out.print(ss + ", ");
        }*/

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List <String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        String [] s = new String[list.size()];
        s = list.toArray(s);


        /*String [] s = new String[list.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = list.get(i);
        }*/
        return s;
    }
}
