package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static <max> void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
        Map<String, Double> map = new TreeMap<>();
        String s;
        while ((s = reader.readLine()) != null) {
            String [] line = s.split(" ");
            String k = line[0];
            double v = Double.parseDouble(line[1]);
            map.computeIfPresent(k, (key, value) -> v + value);
            map.putIfAbsent(k, v);
        }
        reader.close();
        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> m: map.entrySet() ) {
            if (max < m.getValue()) max = m.getValue();
        }
        /*for (Map.Entry<String, Double> m: map.entrySet() ) {
            if (max == m.getValue()) System.out.println(m.getKey());;
        }*/

        final double max1 = max;
        map.forEach((key,val) -> {if(Double.compare(val, max1) == 0) System.out.println(key);});

    }
}
