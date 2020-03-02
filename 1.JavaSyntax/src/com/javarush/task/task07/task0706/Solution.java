package com.javarush.task.task07.task0706;                                                  
                                                  
import java.io.BufferedReader;                                                  
import java.io.IOException;                                                  
import java.io.InputStreamReader;                                                  
                                                  
/*                                                   
Улицы и дома                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {                                                  
        //напишите тут ваш код    
        int[] array = new int[15];     
        int odd=0;
        int even = 0;                                                                                                                                                 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                                                                                                                      
        for (int i=0; i<array.length;i++) {                                                                                                                                                      
            array[i] = Integer.parseInt(reader.readLine());  
            if (i%2==0) even +=array[i];
            else odd +=array[i];                                                                                                                                                    
        }          
        String s = even>odd? "В домах с четными номерами проживает больше жителей." : "В домах с нечетными номерами проживает больше жителей.";
        System.out.println(s);
                                                
    }                                                  
}