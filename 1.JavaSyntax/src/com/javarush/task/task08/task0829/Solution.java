package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }

            list.add(family);
        }

        // Read the house number
        String city = reader.readLine();
        //String name = "";
        for (int i = 0; i< list.size()-1; i++) {
            if (list.get(i).equals(city)) {
                System.out.println (list.get(i+1));
                break;
            }
        }
        
        
    }
}
