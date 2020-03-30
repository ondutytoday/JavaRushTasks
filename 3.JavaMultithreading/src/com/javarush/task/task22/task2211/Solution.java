package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File fileName1 = new File(args[0]);
        File fileName2 = new File(args[1]);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1), "Windows-1251"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2), "UTF-8"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            bufferedWriter.write(s);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

/*    Charset utf8 = Charset.forName("UTF-8");
    Charset windows1251 = Charset.forName("Windows-1251");

    byte[] buff = Files.readAllBytes(Paths.get(args[0]));
    String str = new String(buff,windows1251);
    buff = str.getBytes(utf8);
    FileOutputStream fos = new FileOutputStream(args[1]);
fos.write(buff);
fos.close();*/
}
