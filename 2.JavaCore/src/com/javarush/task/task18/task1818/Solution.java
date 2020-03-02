package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String fileName0 = sc.nextLine();
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName0, true));
        BufferedInputStream input1 = new BufferedInputStream(new FileInputStream(fileName1));
        BufferedInputStream input2 = new BufferedInputStream(new FileInputStream(fileName2));

        byte [] buf1 = new byte [input1.available()];
        int count = input1.read(buf1);
        out.write(buf1, 0, count);

        byte [] buf2 = new byte [input2.available()];
        count = input2.read(buf2);
        out.write(buf2, 0, count);

        out.close();
        input1.close();
        input2.close();
        sc.close();


    }
}
