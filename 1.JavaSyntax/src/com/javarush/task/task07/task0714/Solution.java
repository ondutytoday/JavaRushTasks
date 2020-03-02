package com.javarush.task.task07.task0714;                                                                                                    
                                                                                                    
import java.io.BufferedReader;                                                                                                    
import java.io.InputStreamReader;                                                                                                    
import java.util.ArrayList;        
import java.util.Collections;                                                                                            
                                                                                                    
/*                                                                                                     
Слова в обратном порядке                                                                                                    
*/                                                                                                    
                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) throws Exception {                                                                                                    
        //напишите тут ваш код                                                       
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                   
         ArrayList<String> strings = new ArrayList<String>();                                                   
         for (int i = 0; i < 5; i++) {                                                   
             String s = reader.readLine();                                                   
             strings.add(s);                                                   
         }                                                   
                                                   
        strings.remove(2);                                                  
        Collections.reverse(strings);                                                  
        for (int i = 0; i < 4; i++) { 
            System.out.println(strings.get(i)); 
        }                                                 
                                                  
                                                                                          
    }                                                                                                    
}