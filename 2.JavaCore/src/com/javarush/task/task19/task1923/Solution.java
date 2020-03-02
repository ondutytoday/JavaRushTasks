package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        String s;
        while ((s = file1.readLine()) != null) {
            Pattern p = Pattern.compile("\\d+");
            String [] words = s.split(" ");
            for (String w : words) {
                Matcher m = p.matcher(w);
                if (m.find()) file2.write(w + " ");
            }
        }

        file1.close();
        file2.close();
    }
}
