package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        String mCHAR = "йцукенгшщзхъфсмитьбюЙЦУКЕНГШЩЗХЪЭЖДЛОРП";
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
     //   Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        //Map<String, String> copy = new HashMap<>(map);
        List <String> list = new ArrayList<String>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            list.add(pair.getValue());
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (Map.Entry<String, String> pair : map.entrySet()) {
                if (pair.getValue().equals(list.get(i))) count++;
            }
            if (count >1) removeItemFromMapByValue(map, list.get(i));
            count = 0;
        }


        /*Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            removeItemFromMapByValue(pair, pair.getValue());
        }*/

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
