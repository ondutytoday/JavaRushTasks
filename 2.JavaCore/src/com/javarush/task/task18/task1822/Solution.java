package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));
        //if (inputString.startsWith(args[0]+" ")) System.out.println(inputString);

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        int id = Integer.parseInt(args[0]);
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        StringBuilder productName = new StringBuilder();
        int quantity;
        double price;
        while (in.ready()) {
            String[] line = in.readLine().split(" ");
            if (Integer.parseInt(line[0]) == id) {
                quantity = Integer.parseInt(line[line.length-1]);
                price = Double.parseDouble(line[line.length-2]);
                for (int i = 1; i < line.length-2; i++) {
                    productName.append(line[i]).append(" ");
                }
                System.out.println(id + " " + productName + " " + price + " " + quantity);
                break;
            }
        }



        in.close();
        sc.close();
    }
}
