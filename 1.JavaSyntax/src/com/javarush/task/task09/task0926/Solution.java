package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] array1 = {3, 4, 6, 78, 2};
        int[] array2 = {56, 45};
        int[] array3 = {3, 4, 78, 2};
        int[] array4 = {3, 4, 28, 33, 6, 78, 2};
        int[] array5 = new int[0];
        list.add(array1);
        list.add(array2);
        list.add(array3);
        list.add(array4);
        list.add(array5);

        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
