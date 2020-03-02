package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));
        Scanner sc = new Scanner(System.in);
        String crudFile = sc.nextLine();
        sc.close();
        if (args.length >= 2 && (args[0].equals("-u") || args[0].equals("-d"))) {
            Map<Integer, String> fileContent = new LinkedHashMap<Integer, String>();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(crudFile), "UTF-8"));
            int id;
            String line;
            while ((line = in.readLine()) != null) {
                id = Integer.parseInt(line.substring(0, 8).trim());
                fileContent.put(id, line);
            }
            in.close();
            int idArg;
            switch (args[0]) {
                case "-u":
                    idArg = Integer.parseInt(args[1]);
                    String idString = String.format("%-8d", idArg);
                    String productName = String.format("%-30.30s", args[2]);
                    String price = String.format(Locale.ENGLISH,"%-8.2f", Double.parseDouble(args[3]));
                    String quantity = String.format("%-4d", Integer.parseInt(args[4]));
                    String s = idString + productName + price + quantity;
                    fileContent.put(idArg, s);
                    break;
                case "-d":
                    idArg = Integer.parseInt(args[1]);
                    fileContent.remove(idArg);
                    break;
            }
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(crudFile), "UTF-8"));
            for (Map.Entry<Integer, String> item: fileContent.entrySet()) {
                out.write(item.getValue());
                out.newLine();
            }
            out.close();

        }
    }
}
