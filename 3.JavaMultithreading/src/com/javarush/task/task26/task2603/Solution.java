package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator <T> implements Comparator<T>{

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... t) {
            comparators = t;
        }

        public int compare (T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator: comparators ) {
                result = comparator.compare(o1,o2);
                if (result != 0) break;
            }
            return result;
        }

       /* public int compare(T o1, T o2) {
            return Arrays.stream(comparators)
                    .flatMap(comparator -> Stream.of(comparator.compare(o1,o2)))
                    .filter( num -> num != 0)
                    .findFirst()
                    .orElse(0);
        }*/
    }
}
