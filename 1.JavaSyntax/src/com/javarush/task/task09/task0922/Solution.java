package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        //String string = "2015-05-15";
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = oldDateFormat.parse(string);
        String newDate = newDateFormat.format(date).toUpperCase();
        System.out.println(newDate);
    }
}
