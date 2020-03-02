package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int min(int i, int j) {
        int n = i > j ? j : i;
        return n;
    }

    public static long min(long i, long j) {
        long n = i > j ? j : i;
        return n;
    }

    public static double min(double i, double j) {
        double n = i > j ? j : i;
        return n;
    }
}
