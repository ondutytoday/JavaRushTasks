package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        List <String> listOfMonth = new ArrayList<String> ();
        listOfMonth.add("January");
        listOfMonth.add("February");
        listOfMonth.add("March");
        listOfMonth.add("April");
        listOfMonth.add("May");
        listOfMonth.add("June");
        listOfMonth.add("July");
        listOfMonth.add("August");
        listOfMonth.add("September");
        listOfMonth.add("October");
        listOfMonth.add("November");
        listOfMonth.add("December");
        
        String month = reader.readLine();
        
        for (int i = 0; i<listOfMonth.size(); i++){
            if (month.equals(listOfMonth.get(i))) {
                System.out.printf ("%s is the %d month", month, i+1);
            }
        }
        
    }
}
