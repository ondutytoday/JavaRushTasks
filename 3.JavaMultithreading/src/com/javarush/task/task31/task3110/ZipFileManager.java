package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream outputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream inputStream = Files.newInputStream(source);) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            outputStream.putNextEntry(zipEntry);
            while (inputStream.available() > 0) {
                byte [] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(buffer);
            }

            outputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}