package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception{

//        Solution sol = new Solution();
//        sol.fillInPropertiesMap();
//        System.out.println(properties.toString());

    }

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "JavaRushPlugin.properties";
        InputStream in = new FileInputStream(fileName);
        load(in);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.putAll(properties);
        props.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);
        for (String key : props.stringPropertyNames() ) {
            properties.put(key, props.getProperty(key));
        }

    }
}
