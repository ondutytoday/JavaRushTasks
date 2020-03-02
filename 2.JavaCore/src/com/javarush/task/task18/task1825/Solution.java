package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
       // System.setIn(new ByteArrayInputStream(new String("1.txt.part2\n1.txt.part1\nend").getBytes()));
        Scanner sc = new Scanner(System.in);
        Map <Integer, String> parts = new TreeMap<Integer, String>();
        String name = "";
        String fileName = "";
        while (!(name = sc.nextLine()).equals("end")) {
            Pattern pattern = Pattern.compile("\\d*$");
            Matcher matcher = pattern.matcher(name);
            matcher.find();
            String s = matcher.group();
            parts.put(Integer.parseInt(s), name);
            if (fileName.equals("") && (Integer.parseInt(s) < 10)) {
                fileName = name.substring(0, name.length()-6);
            }

            // тоже как вариант разделения
            /*Pattern pattern = Pattern.compile(".part\\d+$");
            Matcher matcher = pattern.matcher(fileNames.get(0));      //fileNames - ArrayList имен файлов
            int splitIndex=0;
            while (matcher.find()) {
                splitIndex = matcher.start();
            }*/

            //System.out.println(matcher.group());
            //System.out.println(fileName);
        }

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
        for (Map.Entry<Integer, String> part : parts.entrySet()) {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(part.getValue()));
            byte [] buf = new byte[in.available()];
            int count = in.read(buf);
            out.write(buf);
            in.close();
        }
        //System.out.println(parts.toString());
        out.close();

    }
}
