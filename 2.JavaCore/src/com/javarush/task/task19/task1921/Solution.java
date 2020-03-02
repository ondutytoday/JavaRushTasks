package com.javarush.task.task19.task1921;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                Pattern letters = Pattern.compile("[a-zA-ZА-Яа-я\\-]+");
                Pattern digits = Pattern.compile("\\d+");
                Matcher matcherLetters = letters.matcher(s);
                Matcher matcherDigits = digits.matcher(s);
                StringBuilder name = new StringBuilder();
                while (matcherLetters.find()) {
                    name.append(matcherLetters.group()).append(" ");
                }
                String namename = name.toString().trim();
                matcherDigits.find();
                int day = Integer.parseInt(matcherDigits.group());
                matcherDigits.find();
                int month = Integer.parseInt(matcherDigits.group());
                matcherDigits.find();
                int year= Integer.parseInt(matcherDigits.group());
                Calendar calendar = new GregorianCalendar();
                calendar.set(year, month-1, day);
                Date date = new Date(calendar.getTimeInMillis());
                PEOPLE.add(new Person(namename, date));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
