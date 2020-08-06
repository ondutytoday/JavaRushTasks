package com.javarush.task.task31.task3106;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path resultFileName = Paths.get(args[0]);
        List<Path> fileNamePart = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            fileNamePart.add(Paths.get(args[i]));
        }
        Collections.sort(fileNamePart);
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(resultFileName));

        for (Path p : fileNamePart) {
            ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(p));
            byte[] buffer = new byte[8 * 1024];
            int len;
            while ((len = zipInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
            zipInputStream.close();
        }
        zipOutputStream.close();
    }


}
