package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        String [] strings = urlString.split("/");
        String fileName = strings[strings.length-1];
        //System.out.println(fileName);
        InputStream in = url.openStream();
        Path temp = Files.createTempFile("", "");
        Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
        Path destinationPath = Paths.get(downloadDirectory.toString() +"/" + fileName);
        Files.move(temp, destinationPath , StandardCopyOption.REPLACE_EXISTING);

        in.close();
        return destinationPath;
    }
}
