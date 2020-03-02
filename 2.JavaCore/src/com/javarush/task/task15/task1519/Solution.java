package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormatSymbols;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")) {
            if (isNumeric(s) == 1) {
                Double d = Double.parseDouble(s);
                print(d);
            } else if (isNumeric(s) == 0) {
                Integer i = Integer.parseInt(s);
                if (i.compareTo(0) > 0 && i.compareTo(128) < 0) {
                    int a = i;
                    short sh = (short) a;
                    print(sh);
                } else print(i);
            } else print(s);

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

    public static int isNumeric(String s) {

        //1 - double
        //0 - integer
        //-1 - not a digit

        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
        char minusSign = decimalFormatSymbols.getMinusSign();

        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != minusSign) return -1;

        char decimalSeparator = '.';
        boolean isSeparatorFound = false;

        for (char ch : s.substring(1).toCharArray()) {
            if (!Character.isDigit(ch)) {
                if (ch == decimalSeparator && !isSeparatorFound) {
                    isSeparatorFound = true;
                    continue;
                }
                return -1;
            }
        }
        if (isSeparatorFound) return 1;
        else return 0;
    }


}
