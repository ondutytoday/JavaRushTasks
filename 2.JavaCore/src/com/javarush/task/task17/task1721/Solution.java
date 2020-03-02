package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
        try (BufferedReader bufferedReader1 =
                     new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)))) {
            while (bufferedReader1.ready()) {
                String s = bufferedReader1.readLine();
                allLines.add(s);
            }
        } catch (IOException e) {
            System.out.println("File1 not found");
        }
        try (BufferedReader bufferedReader2 =
                     new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)))) {
            while (bufferedReader2.ready()) {
                String s = bufferedReader2.readLine();
                forRemoveLines.add(s);
            }
        } catch (IOException e) {
            System.out.println("File2 not found");
        }

        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Data Error");
        }

        sc.close();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException ();
        }

    }
}
