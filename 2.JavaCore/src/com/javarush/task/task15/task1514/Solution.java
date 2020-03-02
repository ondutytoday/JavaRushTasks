package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.5, "123");
        labels.put(1.2, "456");
        labels.put(3.2, "2");
        labels.put(4.5, "763545343");
        labels.put(1.0, "1");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
