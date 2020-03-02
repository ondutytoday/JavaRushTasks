package com.javarush.task.task19.task1922;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));
        BufferedReader buf = null;
        try (BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            buf = new BufferedReader(new FileReader(fileName));
            int count = 0;
            String s;
            while ((s = buf.readLine()) != null) {
                for (String w : words ) {
                    Pattern p = Pattern.compile("\\b" + w + "\\b");
                    Matcher m = p.matcher(s);
                    while (m.find()) count++;
                }
                if (count == 2) System.out.println(s);
                count = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
