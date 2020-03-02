package com.javarush.task.task08.task0812;                                                                                                    
                                                                                                    
import java.io.BufferedReader;                                                                                                    
import java.io.IOException;                                                                                                    
import java.io.InputStreamReader;                                                                                                    
import java.util.ArrayList;                                                                                                    
import java.util.List;                                                                                                    
                                                                                                    
/*                                                                                                     
Cамая длинная последовательность                                                                                                    
*/                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) throws IOException {                                                                                                    
        //напишите тут ваш код                                                                                                    
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
        List <Integer> list = new ArrayList<Integer>();                                                  
                                                  
        for (int i = 0; i <10 ; i++) {                                                  
            list.add(Integer.parseInt(reader.readLine()));                                                  
        }                                                  
        int sequence = 1; //sequence - последовательность
        int sequenceResult = 1;
        for (int i = 1; i <list.size() ; i++) {
            if (list.get(i).equals(list.get(i-1))) {
                sequence++;
                if (sequenceResult < sequence) {
                    sequenceResult = sequence;
                }
            }

            else {
                if (sequenceResult < sequence) {
                    sequenceResult = sequence;
                }
                sequence = 1;
            }
        }
        System.out.println(sequenceResult);                                                 
                                                                                                
    }                                                                                                    
}