package com.javarush.task.task19.task1924;



import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = file.readLine()) != null) {
            for (Map.Entry<Integer, String> entry: map.entrySet() ) {
                Pattern p = Pattern.compile("\\b" + entry.getKey() + "\\b");
                Matcher m = p.matcher(s);
                s = m.replaceAll(entry.getValue());

            }
            System.out.println(s);
        }

        file.close();
    }
}
