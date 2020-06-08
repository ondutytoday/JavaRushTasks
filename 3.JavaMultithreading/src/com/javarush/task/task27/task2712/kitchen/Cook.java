package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;
    private final StatisticManager manager = StatisticManager.getInstance();

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg
                + ", cooking time "
                + order.getTotalCookingTime() + "min");
        EventDataRow event = new CookedOrderEventDataRow(order.getTabletName(), name, order.getTotalCookingTime()*60, order.getDishes());
        manager.register(event);
        setChanged();
        notifyObservers(arg);
    }
}
