package com.javarush.task.task08.task0818;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Сталлоне", 500);
        map.put("Vasileva", 120);
        map.put("Sasileva", 750);
        map.put("Basileva", 55);
        map.put("Vталлоне", 2012);
        map.put("Masileva", 501);
        map.put("Kasileva", 12);
        map.put("Lasileva", 555);
        map.put("Uasileva", 63);
        map.put("Hasileva", 364);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().compareTo(500) < 0) it.remove();
        }
    }

    public static void main(String[] args) {

    }
}