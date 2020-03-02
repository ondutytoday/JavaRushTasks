package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int max(int i, int j) {
        int n = i < j ? j : i;
        return n;
    }

    public static long max(long i, long j) {
        long n = i < j ? j : i;
        return n;
    }

    public static double max(double i, double j) {
        double n = i < j ? j : i;
        return n;
    }
}
