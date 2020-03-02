package com.javarush.task.task08.task0816;                                                                                                    
                                                                                                    
import java.text.DateFormat;                                                                                                    
import java.text.ParseException;                                                                                                    
import java.text.SimpleDateFormat;                                                                                                    
import java.util.*;                                                                                                    
                                                                                                    
/*                                                                                                     
Добрая Зинаида и летние каникулы                                                                                                    
*/                                                                                                    
                                                                                                    
public class Solution {                                                                                                    
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Vasileva", dateFormat.parse("JULY 4 1986"));
        map.put("Sasileva", dateFormat.parse("FEBRUARY 5 1986"));
        map.put("Basileva", dateFormat.parse("JUNE 6 1986"));
        map.put("Vталлоне", dateFormat.parse("MAY 17 2012"));
        map.put("Masileva", dateFormat.parse("APRIL 23 1986"));
        map.put("Kasileva", dateFormat.parse("JANUARY 11 1986"));
        map.put("Lasileva", dateFormat.parse("JULY 3 1986"));
        map.put("Uasileva", dateFormat.parse("AUGUST 2 1986"));
        map.put("Hasileva", dateFormat.parse("SEPTEMBER 5 1986"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Date date = it.next().getValue();
            int month = date.getMonth();
            if (month == 5 || month == 6 || month ==7) it.remove();
        }

    }                                                                                             
                                                                                                    
    public static void main(String[] args) {                                                                                                    
                                                                                                    
    }                                                                                                    
}