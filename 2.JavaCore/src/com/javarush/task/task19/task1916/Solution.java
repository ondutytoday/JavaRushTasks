package com.javarush.task.task19.task1916;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = sc.readLine();
        String fileName2 = sc.readLine();
        sc.close();

//        String fileName1 = "1.txt";
//        String fileName2 = "2.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

        List<String> listFile1 = new ArrayList<>();
        List<String> listFile2 = new ArrayList<>();

        fillArrayList(reader1, listFile1);
        fillArrayList(reader2, listFile2);
        int i = 0, j = 0;
        while (i < listFile1.size() && j < listFile2.size()) {
            if (listFile1.get(i).equals(listFile2.get(j))) {
                lines.add(new LineItem(Type.SAME, listFile1.get(i)));
                i++;
                j++;
            } else {
                if ((i + 1) < listFile1.size() && listFile1.get(i + 1).equals(listFile2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, listFile1.get(i)));
                    i++;
                } else if ((j + 1) < listFile2.size() && listFile1.get(i).equals(listFile2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, listFile2.get(j)));
                    j++;
                }
            }
        }
        if (i >= listFile1.size()) {
            lines.add(new LineItem(Type.ADDED, listFile2.get(j)));
        }
        else if (j >= listFile2.size()) {
            lines.add(new LineItem(Type.REMOVED, listFile1.get(i)));
        }

       // System.out.println(lines);

        reader1.close();
        reader2.close();
    }

    private static void fillArrayList(BufferedReader reader, List<String> listfile) throws IOException {
        String s;
        while ((s = reader.readLine()) != null) {
            listfile.add(s);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
