package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //StringBuilder string = new StringBuilder(new BufferedReader(new FileReader(fileName)).readLine());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(/*"1.txt"*/ fileName));
        StringBuilder string = new StringBuilder();
        while (bufferedReader.ready()) {
            string.append(bufferedReader.readLine()).append(" ");
        }
        List<String> array = new ArrayList<>(Arrays.asList(string.toString().split(" ")));
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                String str1 = array.get(i);
                String str2 = array.get(j);
                if (str1.equals(new StringBuilder(str2).reverse().toString())) {
                    Pair p = new Pair(str1, str2);
                    if (!result.contains(p)) {
                        result.add(p);
                    }
                }
            }

        }

        System.out.println(result);

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
