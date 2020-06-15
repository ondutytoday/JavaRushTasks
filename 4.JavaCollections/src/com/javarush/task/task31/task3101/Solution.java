package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File source = new File(args[1]);
        File resultFileAbsolutePath = new File(source.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(source, resultFileAbsolutePath);

        Map<String, File> files = new TreeMap<>();
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue, path.listFiles());

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            if (currentFile.isDirectory()) {
                Collections.addAll(queue, currentFile.listFiles());
            } else if (currentFile.length() <= 50) {
                files.put(currentFile.getName(), currentFile);
            }
        }

        try (FileOutputStream writer = new FileOutputStream(resultFileAbsolutePath)) {
            for (Map.Entry<String, File> val : files.entrySet()) {
                try (FileInputStream reader = new FileInputStream(val.getValue())) {
                    byte[] buff = new byte [reader.available()];
                    int count = reader.read(buff);
                    writer.write(buff);
                    writer.write("\n".getBytes());
                }
            }
        }
    }



}
