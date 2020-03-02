package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        String s;
        while ((s = reader.readLine()) != null) {
            String [] line = s.split(" ");
            String k = line[0];
            double v = Double.parseDouble(line[1]);
            map.computeIfPresent(k, (key, value) -> v + value);
            map.putIfAbsent(k, v);
        }
        for (Map.Entry<String, Double> m: map.entrySet() ) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        reader.close();
    }
}
