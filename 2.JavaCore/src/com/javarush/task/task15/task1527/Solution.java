package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        Pattern patternParam = Pattern.compile("(?<=[&?])(\\w+)");
        Matcher matcherParam = patternParam.matcher(string);
        while (matcherParam.find()) {
            System.out.print(matcherParam.group() + " ");
        }
        System.out.println("");

        Pattern patternString = Pattern.compile("(?<=(obj=)).+?((?=&)|$)");
        Matcher matcherString = patternString.matcher(string);
        ArrayList <String> list = new ArrayList<>();
        while (matcherString.find()) {
            list.add(matcherString.group());
        }

        Pattern patternDouble = Pattern.compile ("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$");
                //("-?\\d+\\.\\d+");
        Matcher matcherDouble;
        for (String s : list ) {
            matcherDouble = patternDouble.matcher(s);
            if (matcherDouble.find()) {
                double d = Double.parseDouble(matcherDouble.group());
                alert (d);
            }
            else alert(s);
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

    /*
    String URL=new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("^(.*?\\?)","");
        for(String s:URL.split("&")) System.out.print(s.replaceAll("=.*$","")+" ");
        System.out.println();
        for(String s:URL.split("&")){
        if(s.replaceAll("=.*$","").equals("obj")){
        try{
        alert(Double.parseDouble(s=s.replaceAll("^[^=]*=","")));
        }catch(NumberFormatException e){
        alert(s);
        }
        }
        }

        Вот и всё, собственно.


        Описание строк:
        1. Создаем URL. Считываем. Обрезаем всё что до первого знака вопроса (включительно) [Повторные знаки ? уже войдут в остаток URL, засчёт связки с квантификатором *? ]
        2. Сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each.
        Внутри псевдо-обрезаем правую часть вместе с =  и выводим на экран содержимое через пробел.
        3. Переходим на следующую строку.
        4. Опять сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each.
        5. Внутри псевдо-обрезав правую часть вместе с = сравниваем, что это obj.
        6.
        7. Обрезаем левую часть до первого знака = (включительно), остаток присваиваем в s.
        Второе и более вхождение знака = тоже уже пойдут в s
        Если s преобразуется в double, то вызовется нужный alert.
        Целые числа (без точки) тоже пройдут. Всё остальное (с посторонними символами) уйдёт в 9 строку.
        8.
        9. Вызов alert с типом String. Содержимое s уже обработано в блоке try

        */