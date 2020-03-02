package com.javarush.task.task14.task1419;

import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }
        try {
            int [] array = new int[2];
            array[3] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            Integer i = null;
            int j = 5 + i;
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            String s = "прювет";
            Integer i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            String s = "прювет";
            char ch = s.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            int [] array = new int [-2];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        try {
            List <String> list = new ArrayList<>();
            list.get(5);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            Stack<Integer> stack = new Stack<>();
            stack.pop();
        } catch (EmptyStackException e) {
            exceptions.add(e);
        }
        try {
            Integer i = (Integer) new Object();
        } catch (ClassCastException  e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayStoreException();
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
