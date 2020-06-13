package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Restaurant {
    private static  final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        List<Tablet> list = new ArrayList<>();
        Cook cookVanya = new Cook("Vanya");
        Cook cookOlya = new Cook ("Olya");
        StatisticManager manager = StatisticManager.getInstance();
        manager.register(cookVanya);
        manager.register(cookOlya);
        Waiter waiter1 = new Waiter();
        cookVanya.addObserver(waiter1);
        cookOlya.addObserver(waiter1);
        OrderManager orderManager = new OrderManager();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            list.add(tablet);
            tablet.addObserver(orderManager);
            tablet.addObserver(orderManager);

        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(list, ORDER_CREATING_INTERVAL));
        thread.start();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }

}
