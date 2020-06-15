package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        File fileRoot = new File(root);
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue, fileRoot.listFiles());
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            if (currentFile.isDirectory()) {
                Collections.addAll(queue, currentFile.listFiles());
            } else {
                list.add(currentFile.getAbsolutePath());
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
