package com.javarush.task.task18.task1804;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
                //"input.txt";

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        int [] bytes = new int[256];
        int temp;
        while ((temp = inputStream.read()) != -1) {
            bytes[temp]++;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 1) {
                System.out.print(((byte) i) + " ");
            }
        }


        sc.close();
        inputStream.close();
    }
}
