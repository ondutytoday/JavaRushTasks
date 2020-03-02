package com.javarush.task.task18.task1801;


import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        byte maxByte = -128;
        int temp;
        while ((temp = inputStream.read()) != -1) {
            if (maxByte < (byte) temp) maxByte = (byte) temp;
        }
        inputStream.close();
        System.out.println(maxByte);

    }
}
