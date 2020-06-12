package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;


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
                createAdvmanager(newOrder);
            }
            return newOrder;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        } catch (NoVideoAvailableException nv) {
            logger.log(Level.INFO, "No video is available for the order " + newOrder);
            setChanged();
            notifyObservers(newOrder);
            return newOrder;
        }
    }

    private void createAdvmanager(Order newOrder) {
        AdvertisementManager manager = new AdvertisementManager(newOrder.getTotalCookingTime()*60);
        setChanged();
        notifyObservers(newOrder);
        manager.processVideos();
    }

    public void createTestOrder() {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            if (!testOrder.isEmpty()) {
                createAdvmanager(testOrder);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException nv) {
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
            setChanged();
            notifyObservers(testOrder);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
