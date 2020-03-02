package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    /*public static long[] getNumbers(long N) {
        long[] result = null;
        return result;
    }*/

    //длина числа
    private static int N;
    //
    private static int[] digitsMultiSet;
    //
    private static int[] testMultiSet;
    //конечный массив чисел армстронга
    private static List<Long> results;
    //задаем максимальную степень для конкретного длины числа N
    private static long maxPow;
    //задаем минимальную степень для конкретного длины числа N
    private static long minPow;
    //методом generate создаем матрицу степеней по вертикали всегда [10] (0-9)
    //по горизонтали в зависимости от maxN [maxN+1] (0-maxN)
    private static long[][] pows;

    public static void main(String[] args) {
        //Инициируем время начала работы
        long start = System.currentTimeMillis();
        //Сам процесс, здесь задаем максимальную длину числа (для лонг - 19)
        List<Long> list = generate(3);
        //Конец работы, выводим результат на экран
        long finish = System.currentTimeMillis();
        System.out.println("Time consumed: " + (finish - start) + " ms");
        System.out.println(list.size());
        System.out.println(list);
    }

    //отсюда начитается вычисления
    //maxN = максимальная длина числа
    public static List<Long> generate(int maxN) {
        //проверяем если наше число больше чем максимально возможное из лонг
        if (maxN >= 20) throw new IllegalArgumentException();
        //создаем матрицу степеней. по вертикали всегда [10] (0-9)
        //по горизонтали в зависимости от maxN [maxN+1] (0-maxN)
        genPows(maxN);
        //инициализируем массив значений с числами армстронга
        results = new ArrayList<>();
        //пока не понимаю
        digitsMultiSet = new int[10];
        //пока не монимаю
        testMultiSet = new int[10];

        //начиная с длины числа = 1 и до длины maxN перебираем в цикле
        for (N = 1; N <= maxN; N++) {
            //минимальная степень - это 10 в степени N - 1
            //пусть N = 3 minPow = 100
            minPow = (long) Math.pow(10, N - 1);
            // максимальная степень - это 10 в степени N
            //пусть N = 3 maxPow = 1000
            maxPow = (long) Math.pow(10, N);
            //начинаем поиск для каждой длины чисел из заданных
            search(9, N, 0);
        }
        //сортируем список результатов по возрастанию
        Collections.sort(results);
        //возвращаем массив результатов
        return results;
    }


    private static void genPows(int maxN) {
        //снова проверяем не больше ли наше число чем макс лонг
        //по ходу лишнее исключение
        if (maxN > 20) throw new IllegalArgumentException();
        //создаем квадратную матрицу степеней
        pows = new long[10][maxN + 1];
        //тут идет проход по первой []  т.е. там где [10]
        for (int i = 0; i < pows.length; i++) {
            // в начале каждой "строки" двусмерного массива инициализируем переменную единицей
            long p = 1;
            //проходимся по каждой строке массива и заполняем строчку значениями
            //i в степени 2, 3 и т.д. до maxN
            // например для maxN = 9
            //i = 0: 1 0 0 0 0 0 0 0 0 0 0
            //i = 1: 1 1 1 1 1 1 1 1 1 1 1
            //i = 2: 1 2 4 8 16 32 64 128 256 512 1024
            //i = 3: 1 3 9 27 81 243 729 2187 6561 19683 59049
            //и т.д. до 9
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
            //maxN = 3
            // 1 0 0 0
            // 1 1 1 1
            // 1 2 4 8
            // 1 3 9 27
            // 1 4 16 64
            // 1 5 25 125
            // 1 6 36 216
            // 1 7 49 343
            // 1 8 64 512
            // 1 9 81 729
        }
    }

    private static boolean check(long pow) {
        //если мбольше максимальной и меньше минимальной то фолс
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        //в любом другом случае
        //заполяем как който тестовый массив нулями
        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        //пока степень больше нуля
        while (pow > 0) {
            //получаем остаток от деления степени на 10
            int i = (int) (pow % 10);
            //
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }


    //digit - это по сути та самая i из массива степеней от 0 до 9
    //unused - наша текущая конкретная длина числа N (т.е. этот метод выполняется в цикле от 1 до maxN)
    //pow - видимо минимально возможная степень, поэтому инициализирована нулем
    //Этот метод выполняется рекурсивно с точкой выхода (pow >= maxPow)
                        //пусть наши значения (9, 3, 0)
    private static void search(int digit, int unused, long pow) {

        //т.е мы идем по массиву степеней с помощью digit (фактически это i), начиная с конца (с 9)
        //и проверяем значения степеней в этом массиве в [digit] и-той строке

        // проверяем pow, чтобы была не больше maxPow (это 10 в степени N)
        // т.е. постепенно будем увеличивать pow

        if (pow >= maxPow) return;

        //digit постепенно уменьшаем, поэтому проверка на -1

        if (digit == -1) {
            //проверяем конкретную степень
            if (check(pow)) results.add(pow);
            return;
        }


        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        //т.к digit = 9, попадаем сюда в основной цикл
        } else {
            // Check if we can generate more than minimum
            //проверяем не получится ли число меньше чем минимальная степень
            //0+1*9 = 9 pows[9][1]
            //0+3*729 = 2200 примерно
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }


}
