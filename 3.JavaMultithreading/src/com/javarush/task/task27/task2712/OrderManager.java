package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread thread = new Thread(() -> {
            Set<Cook> cookList = StatisticManager.getInstance().getCooks();
            while (!Thread.currentThread().isInterrupted()) {

                if (!orderQueue.isEmpty()) {
                    for (Cook cook : cookList) {
                        if (!cook.isBusy() && !orderQueue.isEmpty()) {
                            cook.startCookingOrder(orderQueue.poll());
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                }

            }
        });
        thread.setDaemon(true);
        thread.start();

    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        orderQueue.add(order);
    }
}
