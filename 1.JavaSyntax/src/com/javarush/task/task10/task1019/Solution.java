package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<String, Integer>();
        while (true) {
            String s = reader.readLine();
            if (s == null || s.isEmpty()) break;
            int id = Integer.parseInt(s);
            String name = reader.readLine();
            map.put(name, id);
        }

        map.forEach((String k, Integer v) -> System.out.println(v + " " + k));



    }
}
