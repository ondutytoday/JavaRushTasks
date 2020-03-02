package com.javarush.task.task08.task0815;                                                                                                                                                                                                        
                                                                                                                                                                                                        
import java.util.HashMap;                                                                                                                                                                                                        
import java.util.Map;                                                       
import java.util.Random;      
import java.util.Iterator;                                                                                                                                                                                             
                                                                                                                                                                                                        
/*                                                                                                                                                                                                         
Перепись населения                                                                                                                                                                                                        
*/                                                                                                                                                                                                        
                                                                                                                                                                                                        
public class Solution {                                                                                                                                                                                                        
    public static Map<String, String> createMap() {                                                                                                    
        //напишите тут ваш код                                                                                                    
        Map<String, String> map = new HashMap<String, String>();                                                                                                    
        String mCHAR = "йцукенгшщзхъфсмитьбюЙЦУКЕНГШЩЗХЪЭЖДЛОРП";                                                                                                    
        Random random = new Random();                                                                                                    
                                                                                                    
        for (int i = 0; i <10 ; i++) {                                                                                                    
            String name = "N";                                                                                                    
            String surname = "S";                                                                                                    
            for (int j = 0; j < 4; j++) {   // длина слова 4 буквы                                                                                                    
                int number = random.nextInt(mCHAR.length());                                                                                                    
                name += String.valueOf(mCHAR.charAt(number));                                                                                                    
                surname += String.valueOf(mCHAR.charAt(number));                                                                                                    
            }                                                                                                    
            map.put(surname, name);                                                                                                    
            name = "N";                                                                                                    
            surname = "S";                                                                                                    
        }                                                                                                    
        return map;                                                                                                    
                                                                                                    
    }                                                                                                    
                                                                                                    
    public static int getCountTheSameFirstName(Map<String, String> map, String name) {                                                                                                    
        //напишите тут ваш код                                                                                                    
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();                                                                                                    
        int count = 0;                                                                                                    
        while (it.hasNext()) {                                                                                                    
            if (it.next().getValue().compareTo(name) == 0) count++;                                                                                                    
        }                                                                                                    
        return count;                                                                                                    
    }                                                                                                    
                                                                                                    
    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {                                                                                                    
        //напишите тут ваш код                                                                                                    
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();                                                                                                    
        int count = 0;                                                                                                    
        while (it.hasNext()) {                                                                                                    
            if (it.next().getKey().compareTo(lastName) == 0) count++;                                                                                                    
        }                                                                                                    
        return count;                                                                                                    
                                                                                                    
    }                                                                                                                                                             
                                                                                                                                                                                                        
    public static void main(String[] args) {                                                                                                                                                                                                        
                                                                                                                                                                                                        
    }                                                                                                                                                                                                        
}