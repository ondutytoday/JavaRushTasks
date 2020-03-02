package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
        sc.close();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName1));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName2, true));

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];

            int count = inputStream.read(buffer);
            for (int i = count-1; i >=0 ; i--) {
                outputStream.write(buffer[i]);
            }
        }


        inputStream.close();
        outputStream.close();
    }
}
