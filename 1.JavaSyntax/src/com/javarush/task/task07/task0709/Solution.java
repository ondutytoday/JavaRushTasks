package com.javarush.task.task07.task0709;                                                                                                    
                                                                                                    
import java.io.BufferedReader;                                                                                                    
import java.io.InputStreamReader;                                                                                                    
import java.util.ArrayList;      
import java.util.Collections;                                                                                                     
import java.util.Comparator;                                                                                                  
                                                                                                    
/*                                                                                                     
Выражаемся покороче                                                                                                    
*/                                                                                                    
                                                                                                    
public class Solution {                                                                                                    
                                                                                                        
                                                                                                     
 public static void main(String[] args) throws Exception {                                                                                                     
    ArrayList<String> strings = new ArrayList<String>();                                                                                                    
 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                                                                     
 //String[] s = {"Deaaaaaaan", "Deaaan", "Deaaaaaaaan", "Dean", "Deaaaaaaaan"};                                                                                                     
 for (int i = 0; i < 5; i++) {                                                                                                     
 strings.add(reader.readLine());                                                                                                     
 //s[i]);                                                                                                     
                                                                                                     
 }                                                                                                     
 Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();                                                                                                     
 strings.sort(comparator);                                                                                                     
 //Collections.reverse(strings);                                                                                                     
 System.out.println(strings.get(0));                                                                                                     
 for (int i = 0; i < 4; i++) {                                                                                                     
 //System.out.println(strings.get(i+1));                                                                                                     
 if (strings.get(i + 1).length() == strings.get(i).length()) {                                                                                                     
 System.out.println(strings.get(i + 1));                                                                                                     
 } else break;                                                                                                     
 }                                                                                                     
 }                                                                                                                            
}