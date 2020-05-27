package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the whole path of archive file including file name:");
            String fileOfArchiver = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fileOfArchiver));
            System.out.println("Enter the whole path of file you want to archive including file name:");
            String fileToArchive = reader.readLine();
            zipFileManager.createZip(Paths.get(fileToArchive));
            reader.close();
            new ExitCommand().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
