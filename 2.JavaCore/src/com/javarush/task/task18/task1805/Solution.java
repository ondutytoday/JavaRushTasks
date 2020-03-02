package com.javarush.task.task18.task1805;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        //String fileName = "input.txt";
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        Set<Byte> byteSet = new TreeSet<Byte>();
        int temp;
        while ((temp = inputStream.read()) != -1) {
            byteSet.add((byte)temp);
        }

        for (byte i : byteSet) {
            System.out.print(i + " ");
        }

        sc.close();
        inputStream.close();
    }
}
