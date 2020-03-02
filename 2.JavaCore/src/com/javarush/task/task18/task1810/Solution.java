package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean isMore = true;
        while (isMore) {
            String s = sc.nextLine();
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(s));
            if (inputStream.available() <1000) {
                sc.close();
                inputStream.close();
                isMore = false;
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
