package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));


        StringJoiner joiner = new StringJoiner(",");

        //StringBuilder sb = new StringBuilder();
        String s;
        while ((s = file1.readLine()) != null) {
            String[] words = s.split(" ");
            for (String w :words ) {
                if (w.length() > 6) joiner.add(w);
                    //sb.append(w).append(",");
            }
        }
        //file2.write(sb.toString(), 0, sb.length()-1);
        file2.write(joiner.toString());

        file1.close();
        file2.close();

        /*
        try ( BufferedReader brf = new BufferedReader( new FileReader( args[0] ) );
              BufferedWriter bwf = new BufferedWriter( new FileWriter( args[1] ) ) ) {
            String tmp = brf.lines()
                    .flatMap( s -> Arrays.stream( s.split(" ") ) )
                    .filter( s -> s.length() > 6 )
                    .collect(Collectors.joining(","));
            bwf.write(tmp);
        }
        */

    }
}
