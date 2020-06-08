package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;



import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order newOrder = null;
        try {
            newOrder = new Order(this);
            ConsoleHelper.writeMessage(newOrder.toString());
            if (!newOrder.isEmpty()) {
                AdvertisementManager manager = new AdvertisementManager(newOrder.getTotalCookingTime()*60);
                manager.processVideos();
                setChanged();
                notifyObservers(newOrder);
            }
            return newOrder;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
