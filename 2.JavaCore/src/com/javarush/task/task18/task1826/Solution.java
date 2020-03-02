package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String key = args[0];
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[2]));
        int byteToRead;
        switch (key) {
            case "-e":
                while ((byteToRead = in.read())!=-1) {
                    out.write(byteToRead+1);
                }
                break;
            case "-d":
                while ((byteToRead = in.read())!=-1) {
                    out.write(byteToRead-1);
                }
                break;
        }

        in.close();
        out.close();

    }

}
