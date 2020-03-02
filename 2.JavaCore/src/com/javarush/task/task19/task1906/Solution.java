package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.setIn(new ByteArrayInputStream(new String("1.txt\n2.txt").getBytes()));
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = sc.readLine();
        String fileName2 = sc.readLine();
        sc.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        int charToRead;
        int isEven = 0;
        while ((charToRead = reader.read()) != -1) {
            ++isEven;
            if (isEven % 2 == 0) {
                writer.write(charToRead);
            }
        }
        reader.close();
        writer.close();
    }
}
