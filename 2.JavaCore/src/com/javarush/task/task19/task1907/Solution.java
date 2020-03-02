package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String fileName = sc.readLine();
        sc.close();*/

        String fileName = "1.txt";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;

        int count = 0;
        while ((s = reader.readLine()) != null) {
            Pattern p = Pattern.compile("\\bworld\\b", Pattern.CASE_INSENSITIVE);
            Matcher m= p.matcher(s);System.out.println(m.groupCount());
            while (m.find()) {
                count++;
            }
        }

       System.out.println(count);

        reader.close();
    }
}
