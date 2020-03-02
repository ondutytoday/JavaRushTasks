package com.javarush.task.task05.task0528;                                                                                                    
                                                                                                    
/*                                                                                                     
Вывести на экран сегодняшнюю дату                                                                                                    
*/                                                                                                    
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

                                                                                                  
public class Solution {                                                                                                    
    public static void main(String[] args) {                                                                                                    
        //напишите тут ваш код                                                      
        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat formatDate = new SimpleDateFormat("dd MM YYYY");     
        System.out.println(formatDate.format(calendar.getTime()));                                             
                                                                                                
    }                                                                                                    
}