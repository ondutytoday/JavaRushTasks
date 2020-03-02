package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
        String fileName3 = sc.nextLine();
//        String fileName1 = "input.txt";
//        String fileName2 = "1.txt";
//        String fileName3 = "2.txt";

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName1));
        BufferedOutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(fileName2));
        BufferedOutputStream outputStream3 = new BufferedOutputStream(new FileOutputStream(fileName3));

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);


            if (count%2==0) {
                outputStream2.write(buffer, 0, count/2);
                outputStream3.write(buffer, count/2, count/2);
            } else {
                outputStream2.write(buffer, 0, count/2+1);
                outputStream3.write(buffer, count/2+1, count/2);
            }
        }

        sc.close();
        inputStream.close();
        outputStream2.close();
        outputStream3.close();
    }
}
