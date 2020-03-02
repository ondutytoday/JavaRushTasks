package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        //String fileName = "input.txt";
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        int temp;
        int count = 0;
        while ((temp = inputStream.read()) != -1) {
            if ((char) temp == ',') count++;
        }
        System.out.println(count);

        sc.close();
        inputStream.close();
    }
}
