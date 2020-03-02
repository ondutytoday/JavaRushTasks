package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String s = outputStream.toString().trim();
        int res = calculation(s);
        System.setOut(consoleStream);
        System.out.print(s + " " + res);

    }

    public static int calculation(String s) {
        String[] result = s.split(" ");
        switch (result[1]) {
            case "+":
                return Integer.parseInt(result[0]) + Integer.parseInt(result[2]);

            case "-":
                return Integer.parseInt(result[0]) - Integer.parseInt(result[2]);

            case "*":
                return Integer.parseInt(result[0]) * Integer.parseInt(result[2]);

            default:
                return 0;
        }
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

