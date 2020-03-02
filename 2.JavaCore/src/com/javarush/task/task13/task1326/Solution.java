package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Files.newBufferedReader();
        String path = reader.readLine();
        //"D:\\code\\JavaRushTasks\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (bufferedReader.ready()) {
            int i = Integer.parseInt(bufferedReader.readLine());
            if (i % 2 == 0) list.add(i);
        }
        list.sort(Integer::compareTo);
        for (int i : list) {
            System.out.println(i);
        }
        bufferedReader.close();
        fileInputStream.close();
        reader.close();
    }
}
