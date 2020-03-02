package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = getFileName();
        String fileInLine = getFileInLine(fileName).toString();
        String parametr = args[0];

        Document doc = Jsoup.parse(fileInLine, "", Parser.xmlParser());
        Elements elem = doc.select(parametr);
        for (Element e : elem) {
            System.out.println(e);
        }
    }

    public static StringBuilder getFileInLine(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb;
    }

    public static String getFileName() throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String fileName = sc.readLine();
        sc.close();
        return fileName;
    }
}
