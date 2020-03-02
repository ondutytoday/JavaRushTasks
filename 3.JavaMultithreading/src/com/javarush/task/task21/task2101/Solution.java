package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte [] netAddress = new byte[4];
        for (int i = 0; i < 4; i++) {
           netAddress [i] = (byte) (ip[i] & mask[i]);
        }

        return netAddress;
    }

    public static void print(byte[] bytes) {
        for (byte b: bytes) {
/*
            В Java переменная типа byte в старшем разряде хранит знак.
            При передаче в метод toBinaryString происходит неявное приведение 8-битного байта
            к 32-битному целому. При этом старшие разряды отрицательного числа "добиваются"
            установленными битами и 10000001 превращается в 11111111 11111111 11111111 10000001.
            Что искажает ожидаемый нами результат. Нам надо как-то обнулить старшие биты.
            Бинарное представление 0xFF (255) - это 00000000 00000000 00000000 11111111.
            Применяя операцию побитового И, мы обнуляем биты старших разрядов и получаем
            требуемое нам 00000000 00000000 00000000 10000001.
*/
            String s = String.format("%8s",  Integer.toBinaryString(b & 255)).replace(" ", "0");
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
