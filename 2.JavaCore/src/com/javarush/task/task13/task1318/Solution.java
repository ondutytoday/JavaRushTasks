package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        try
               // (InputStream inStream = new FileInputStream(new Scanner(System.in).nextLine()))
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //Scanner sc = new Scanner(System.in);
            String path = reader.readLine();
            InputStream inStream = new FileInputStream(path);
            OutputStream outStream = new DataOutputStream(System.out);
            while (inStream.available() > 0)
            {
                int data = inStream.read(); //читаем один байт из потока для чтения
               // System.out.print((char) data);
                outStream.write(data); //записываем прочитанный байт в другой поток.
            }

            reader.close();
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}