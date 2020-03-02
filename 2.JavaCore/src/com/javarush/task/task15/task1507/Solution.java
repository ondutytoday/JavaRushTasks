package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

import com.sun.org.apache.xpath.internal.objects.XObject;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix () {
        System.out.println("kuku");
    }

    public static void printMatrix (int a) {
        System.out.println(a);
    }

    public static void printMatrix(int a, int b) {
        System.out.println(a + b);
    }

    public static void printMatrix (String value) {
        System.out.println(value);
    }

    public static void printMatrix (int a, String value) {
        System.out.println(a + value);
    }

    public static void printMatrix(String value, int a) {
        System.out.println(value + a);
    }

    public static void printMatrix(String a, Object o) {
        System.out.println("che ja vasche delayu");
    }

    public static void printMatrix(Object o, String a) {
        System.out.println("ne znayu");
    }
}
