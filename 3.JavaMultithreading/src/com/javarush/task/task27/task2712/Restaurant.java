package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

import java.util.Observable;
import java.util.Observer;

public class Restaurant {
    public static void main(String[] args) {
//        Tablet tablet = new Tablet(1);
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
        Cook cookVanya = new Cook("Vanya");
        Tablet tablet = new Tablet(1);
        tablet.addObserver(cookVanya);
        tablet.createOrder();

    }
}
