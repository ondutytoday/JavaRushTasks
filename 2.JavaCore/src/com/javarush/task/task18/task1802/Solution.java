package com.javarush.task.task18.task1802;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        byte minByte = 127;
        int temp;
        while ((temp = inputStream.read()) != -1) {
            if (minByte > (byte) temp) minByte = (byte) temp;
        }
        sc.close();
        inputStream.close();
        System.out.println(minByte);
    }
}
