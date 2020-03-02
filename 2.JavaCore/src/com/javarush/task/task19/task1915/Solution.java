package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        //System.setIn(new ByteArrayInputStream(new String("1.txt").getBytes()));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
        bos.write(outputStream.toByteArray());
        String s = outputStream.toString();
        System.setOut(consoleStream);
        System.out.println(s);

        reader.close();
        bos.close();


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

