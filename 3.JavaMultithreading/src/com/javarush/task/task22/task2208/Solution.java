package com.javarush.task.task22.task2208;


import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
       /* Map<String, String> params = new LinkedHashMap<>();
        params.put("name", null *//*"Ivanov"*//*);
        params.put("country", null *//*"Ukraine"*//*);
        params.put("city", null *//*"Kiev"*//*);
        params.put("age", null);

        System.out.println(getQuery(params));*/

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> param : params.entrySet()) {
            if(param.getValue() != null /*|| !param.getValue().equals("null")*/) {
                builder.append(param.getKey())
                        .append(" = '")
                        .append(param.getValue())
                        .append("' and ");
            }
        }
        if (builder.length() > 5) builder.delete(builder.length()-5, builder.length());

        return builder.toString();
    }
}

//    StringBuilder sb = new StringBuilder(params.size());
//        params.forEach((key, value)->{
//                if(value!=null)
//                sb.append(key+" = \'"+value+ "\' and ");
//                });
//                return  sb.length()==0?"":sb.toString().substring(0, sb.lastIndexOf(" and "));