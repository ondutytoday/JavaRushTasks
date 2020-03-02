package com.javarush.task.task07.task0713;                                                  
                                                  
import java.io.BufferedReader;                                                  
import java.io.InputStreamReader;                                                  
import java.util.ArrayList;                                                  
                                                  
/*                                                   
Играем в Jолушку                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws Exception {                                                  
        //напишите тут ваш код  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        ArrayList<Integer> mainList = new ArrayList<Integer>(); 
        ArrayList<Integer> list1 = new ArrayList<Integer>(); 
        ArrayList<Integer> list2 = new ArrayList<Integer>(); 
        ArrayList<Integer> list3 = new ArrayList<Integer>(); 
        
        for (int i = 0; i < 20; i++) { 
            String s = reader.readLine(); 
            mainList.add(Integer.parseInt(s));
             
        } 
        boolean b  = true;
        for (int i = 0; i < 20; i++) { 
            if (mainList.get(i)%3==0) {
                list1.add(mainList.get(i));
                b = false;
            }
            if (mainList.get(i)%2==0) {
                list2.add(mainList.get(i));
                b = false;
            }
            if (b) {
                list3.add(mainList.get(i));
                
            }
            b = true;
        }
                          
    printList(list1);
    printList(list2);
    printList(list3);
 }                                                 
    public static void printList(ArrayList<Integer> list) {                                                  
        //напишите тут ваш код    
         for (int i = 0; i < list.size(); i++) { 
              System.out.println(list.get(i));  
        }                                         
    }                                                  
}