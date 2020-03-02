package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new ByteArrayInputStream(new String("1.txt\n2.txt").getBytes()));

        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
        File file1 = new File (fileName1);
        BufferedInputStream in1 = new BufferedInputStream(new FileInputStream(file1));
        byte [] buffer1 = new byte[in1.available()];
        int count1 = in1.read(buffer1);
        BufferedInputStream in2 =  new BufferedInputStream(new FileInputStream(fileName2));
        byte [] buffer2 = new byte[in2.available()];
        int count2 = in2.read(buffer2);
//        byte [] total = new byte[buffer1.length+buffer2.length];
//        System.arraycopy(buffer2,0,total,0,buffer2.length);
//        System.arraycopy(buffer1, 0, total, buffer2.length, buffer1.length);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file1));

        out.write(buffer2);
        out.write(buffer1);


        in1.close();
        in2.close();
        out.close();
        sc.close();

    }
}
