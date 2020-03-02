package com.javarush.task.task17.task1722;

/* 
Посчитаем
*/

/*
    count - переменная типа Integer (не путать с int), она неизменяемая. Значит, если она создана, изменить её уже нельзя.
    Операция инкремента будет не увеличивать count на 1, а создавать новый объект класса Integer со значением 1.
    Синхронизация по count не будет работать, так как каждая нить будет создавать свои объекты и синхронизироваться именно по ним.
    Отсюда вытекает ответ на второй вопрос: почему getCount() всегда получает значение, увеличенное только на 1?
    Ведь если каждая нить войдёт в incrementCount() ещё до того, как values будет занят, значит значение count
    может увеличиться больше чем на один и какие-то ячейки values могут остаться незаполненными.

    Учитывая вышесказанное, попробуем ответить на примере:
    Допустим в метод incrementCount вошла первая нить и создала new Integer(1).
    Потом вторая: Thread 2, создала integer(2).
    Потом, ВНИМАТЕЛЬНО, ЧЕТВЁРТАЯ нить создала Integer(3).
    И наконец ТРЕТЬЯ создала Integer(4).
    Ни одна из нитей не знает о существовании другой, и, соответственно, о существовании других объектов Integer.
    Поэтому, когда первая нить захватит values, getCount получит Integer(1);
    вторая нить получит Integer(2);
    третья - Integer(4) (именно тот, который она создала);
    четвёртая - Integer(3).
    Обратите внимание, абсолютно не важно в каком порядке будет заполняться массив.
    В нашем примере заполнится сначала первая ячейка, потом вторая, потом четвёртая, потом третья.
    Значение имеет то, что ни одно значение в этом случае count не будет ни повторяться, ни пропускаться.
    В объяснении я специально процесс создания Integer и изменения values, разделил.
    В реальности это всё будет смешано в кучу. Ни о какой заранее определённой последовательности здесь речь не идёт)


    Почему не работает синхронизация по count?
    обьекты Integer иммутабельны, т.е. в процессе инкремента count будет уже не тот, и синхронизация слетит
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }

        
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }


    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (values) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}
