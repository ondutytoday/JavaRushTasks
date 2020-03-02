package com.javarush.task.task07.task0712;                                                  
                                                  
import java.io.BufferedReader;                                                  
import java.io.IOException;                                                  
import java.io.InputStreamReader;                                                  
import java.util.ArrayList;                                                  
                                                  
/*                                                   
Самые-самые                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {                                                  
        //напишите тут ваш код   
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
 ArrayList<String> strings = new ArrayList<String>(); 
 for (int i = 0; i < 10; i++) { 
 String s = reader.readLine(); 
 strings.add(s); 
 } 
 int min = strings.get(0).length(); 
 int max = strings.get(0).length(); 
 int minIndex = 0; 
 int maxIndex = 0; 
 for (int i = 1; i < 10; i++) { 
 if (strings.get(i).length() < min) { 
 minIndex = i; 
 min = strings.get(i).length();
 } 
 } 
 for (int i = 1; i < 10; i++) { 
 if (strings.get(i).length() > max) { 
 maxIndex = i; 
 max = strings.get(i).length();
 } 
 } 
 
 String s; 
 s = minIndex < maxIndex ? strings.get(minIndex) : strings.get(maxIndex); 
 System.out.println(s);                                               
    }                                                  
}