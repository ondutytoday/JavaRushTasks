package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = sc.readLine();
        String fileName2 = sc.readLine();
        sc.close();

//        String fileName1 = "1.txt";
//        String fileName2 = "2.txt";

        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        String s;
        while ((s = reader.readLine()) != null) {
            Pattern p = Pattern.compile("\\p{Punct}+");
            Matcher m= p.matcher(s);
            s = m.replaceAll("");
            writer.write(s);
        }
        reader.close();
        writer.close();
    }
}
