package com.javarush.task.task07.task0702;                                                                                                    
                                                                                                    
import java.io.BufferedReader;                                                                                                    
import java.io.InputStreamReader;    
import java.io.IOException;                                                    
                                                                                               
                                                                                                    
/*                                                                                                     
Массив из строчек в обратном порядке                                                                                                    
*/                                                                                                    
                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) throws Exception {                                                  
        String[] array = new String[10];                                                  
        ;                                                  
        initializeArray(array);                                                  
        for (int i = 9;i>=0;i--) {                                                  
            System.out.println(array[i]);                                                  
        }                                                  
                                                          
    }                                                  
                                                  
    public static String[] initializeArray(String[] array) throws IOException {                                                  
        // создай и заполни массив                                                  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
        for (int i = 0; i < 8; i++) {                                                  
            array[i] = reader.readLine();                                                  
        }                                                  
                                                  
        return array;                                                  
    }                                                                                              
}