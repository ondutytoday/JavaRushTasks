package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediane;
        Arrays.sort(array);
        if (array.length%2!=0) mediane = array[array.length/2];
        else mediane = (array[array.length/2] + array[array.length/2-1])/2;
        Arrays.sort(array, Comparator.comparingInt(a -> Math.abs(mediane - a)));
        return array;
    }
}
