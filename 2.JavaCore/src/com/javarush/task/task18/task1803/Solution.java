package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.*;

/* 
Самые частые байты
*/

//Классное решение

/*
Задача не сложная, если взглянуть на комменты и понять, что конкретно от нас хотят:
        1. В первом цикле считываем по очереди байт из файла, берем из заранее созданного массива
        на 256 int значение по индексу (который равен значению байта), увеличиваем значение на единицу
        и возвращаем новое значение обратно в массив по этому же индексу.
        2. Во втором цикле проходимся по массиву, если значение ячейки массива больше двух (максимальное),
        то просто печатаем сам индекс через пробел.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        Map<Byte, Long> bytes = new HashMap<>();
        int temp;
        long maxValues = 0;
        while ((temp = inputStream.read()) != -1) {
            if (bytes.containsKey((byte) temp)) {
                bytes.put((byte) temp, (bytes.get((byte) temp).longValue() + 1));
                if (maxValues < bytes.get((byte) temp).longValue()) {
                    maxValues = bytes.get((byte) temp).longValue();
                }
            } else bytes.put((byte) temp, 1L);
        }

        for (Map.Entry<Byte, Long> value : bytes.entrySet()) {
            if (maxValues == value.getValue()) {
                System.out.print(value.getKey() + " ");
            }
        }


        sc.close();
        inputStream.close();
    }

    //Сортировка мапы по значению

    public static <Byte, Long extends Comparable<Long>> Map<Byte, Long> sortByValue(Map<Byte, Long> map) {
        List<Map.Entry<Byte, Long>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Byte, Long>>() {
            @Override
            public int compare(Map.Entry<Byte, Long> o1, Map.Entry<Byte, Long> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Collections.reverse(list);

        Map<Byte, Long> result = new LinkedHashMap<>();
        for (Map.Entry<Byte, Long> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
