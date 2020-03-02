package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.setIn(new ByteArrayInputStream(new String("1.txt\n2.txt").getBytes()));
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
        FileInputStream in = new FileInputStream(fileName1);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName2));
        BufferedReader reader =  new BufferedReader(new InputStreamReader(in));
        String [] line = reader.readLine().split(" ");
        for ( String s: line ) {
            Double d = Double.parseDouble(s);
            //DecimalFormat df = new DecimalFormat("#");
            //String answer = df.format(d);
            //byte [] array = answer.getBytes();
            Integer i = (int) Math.round(d);
            out.write(i.toString().getBytes());
            out.write(" ".getBytes());
        }

        in.close();
        reader.close();
        out.close();
        sc.close();
    }
}

//BufferedReader in =  new BufferedReader(new FileReader(fileName1));
//PrintStream out = new PrintStream(fileName2);

        /*while (in.ready()) {
               // available() >0) {
            String [] line = in.readLine().split(" ");
            for ( String s: line ) {
                double d = Double.parseDouble(s);
                out.printf("%.0f ", d);
//                System.out.printf("%.0f", d);
//                System.out.println();
            }
        }*/