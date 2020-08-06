package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties p = new Properties();
        try {
            Path path = Paths.get(fileName);
            File file = path.toFile();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            if (fileName.toLowerCase().endsWith("xml")) {
                p.loadFromXML(bis);
            } else {
                p.load(bis);
            }

            return p;
        } catch (IOException e) {
            return p;
        }
    }
}
