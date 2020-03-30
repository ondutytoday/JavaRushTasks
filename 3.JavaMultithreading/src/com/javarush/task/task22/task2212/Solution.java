package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        Pattern p = Pattern.compile("^\\+\\d+[(]{0,1}\\d{3}[)]{0,1}\\d+[-]{0,1}\\d+[-]{0,1}\\d+$");
        Matcher m = p.matcher(telNumber);
        return m.find();
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+38(050)1234567"));

    }
}
