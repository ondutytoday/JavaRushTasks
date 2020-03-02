package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        //String string = "Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.";
        ArrayList<Character> vowelsList = new ArrayList<Character>();           //vowels гласные буквы
        ArrayList<Character> consonantsList = new ArrayList<Character>();       //consonants согласные буквы
        for (int i = 0; i < string.length(); i++) {
            if(isVowel(string.charAt(i))) {
                vowelsList.add(string.charAt(i));
                vowelsList.add(' ');
            }
            else if (!Character.isSpaceChar(string.charAt(i))){
                consonantsList.add(string.charAt(i));
                consonantsList.add(' ');
            }
        }
        for (Character ch:
                vowelsList) {
            System.out.print(ch);
        }
        System.out.println();
        for (Character ch:
                consonantsList) {
            System.out.print(ch);
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}