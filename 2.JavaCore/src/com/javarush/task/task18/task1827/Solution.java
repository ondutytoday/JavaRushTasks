package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws Exception {

        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));
        Scanner sc = new Scanner(System.in);
        String crudFile = sc.nextLine();
        sc.close();
        if (args.length == 4 && args[0].equals("-c")) {
            List<String> list = new ArrayList <String> ();
            String productName = String.format("%-30.30s", args[1]);
            double priceDouble = Double.parseDouble(args[2]);
            String price = String.format(Locale.ENGLISH,"%-8.2f", priceDouble);
            int quantityInt = Integer.parseInt(args[3]);
            String quantity = String.format("%-4d", quantityInt);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(crudFile), "UTF-8"));
            String id;
            int idInt = 0;
            while (in.ready()) {
                String s = in.readLine();
                list.add(s);
                id = s.substring(0, 8).trim();
                idInt = idInt < Integer.parseInt(id) ? Integer.parseInt(id) : idInt;
            }
            in.close();
            id = String.valueOf(String.format("%-8d", ++idInt));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(crudFile), "UTF-8"));
            for (String s : list) {
                out.write(s);
                out.newLine();
            }
            out.write(id+ productName+  price+ quantity);
            out.close();

        }
    }
}
