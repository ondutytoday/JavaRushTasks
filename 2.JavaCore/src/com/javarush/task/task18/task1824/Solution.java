package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //System.setIn(new ByteArrayInputStream(new String("1.txt\n3.txt").getBytes()));

        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        String fileName;

        while (!isExit) {
            fileName = sc.nextLine();
            try (InputStream in = new FileInputStream(fileName)){

            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                sc.close();
                isExit = true;
            } catch (IOException e) {

            }
        }


    }
}
