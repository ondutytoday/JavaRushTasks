package com.javarush.task.task32.task3201;


import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(args [0], "rw");
        file.seek(Long.parseLong(args[1]));
        file.writeBytes(args[2]);

    }
}
