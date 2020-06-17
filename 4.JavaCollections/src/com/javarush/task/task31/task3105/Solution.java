package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get(args[0]);
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));

// Создаем временный файл
        Path tempZipFile = Files.createTempFile(null, null);
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile));
        List<Path> archiveFiles = new ArrayList<>();
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();
            archiveFiles.add(Paths.get(fileName));

            zipOutputStream.putNextEntry(new ZipEntry(fileName));
            copyData(zipInputStream, zipOutputStream);

            zipInputStream.closeEntry();
            zipOutputStream.closeEntry();

            zipEntry = zipInputStream.getNextEntry();
        }

        InputStream streamFile = Files.newInputStream(file);
        ZipEntry entry = new ZipEntry(file.toString());
        zipOutputStream.putNextEntry(entry);
        copyData(streamFile, zipOutputStream);
        zipOutputStream.closeEntry();


        // Перемещаем временный файл на место оригинального
        Files.move(tempZipFile, Paths.get(args[1]), StandardCopyOption.REPLACE_EXISTING);
        zipInputStream.close();
        zipOutputStream.close();
        streamFile.close();
    }

    private static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

}
