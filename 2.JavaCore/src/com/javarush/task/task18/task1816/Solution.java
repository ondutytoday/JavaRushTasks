package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedInputStream =
                new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        int count = 0;
        StringBuilder string = new StringBuilder();
        while (bufferedInputStream.ready()) {
            string.append(bufferedInputStream.readLine());
        }
        char [] arrayOfChars = string.toString().toCharArray();
        for (char ch: arrayOfChars ) {
            if (ch >= 'A' && ch <= 'Z') count++;
            if (ch >= 'a' && ch <= 'z') count++;
        }
        System.out.println(count);
        bufferedInputStream.close();
    }
}
