package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

/* 
Что внутри папки?
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringToPath = reader.readLine();
        Path path = Paths.get(stringToPath);
        if (Files.isDirectory(path)) {

            long countOfDirectories = Files.walk(path)
                    //.parallel() //валидатор ругается на опасную операцию
                    .filter(p -> Files.isDirectory(p))
                    .count();
            long countOfFiles = Files.walk(path)
                    .filter(p -> Files.isRegularFile(p))
                    .count();
            long countOfBytes = Files.walk(path)
                    .filter(p -> Files.isRegularFile(p))
                    .mapToLong(path1 -> {
                        try {
                            return Files.size(path1);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return 0;
                        }

                    })
                    .sum();
            System.out.printf("Всего папок - %d%n", countOfDirectories-1);
            System.out.printf("Всего файлов - %d%n", countOfFiles);
            System.out.printf("Общий размер - %d%n", countOfBytes);

        } else {
            System.out.printf("%s - не папка", path.toString());
        }

    }

}
