package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(fileName));


        String s;
        while ((s = file.readLine()) != null) {
            System.out.println(new StringBuilder(s).reverse());
        }
        file.close();
    }
}
