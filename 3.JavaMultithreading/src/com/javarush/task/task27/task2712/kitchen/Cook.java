package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private boolean busy;
    private String name;
    //private final StatisticManager manager = StatisticManager.getInstance();

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder (Order order) {
        busy = true;
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
                order.toString(),
                this.name,
                order.getTotalCookingTime() * 60,
                order.getDishes()));
        try {
            Thread.sleep(10*order.getTotalCookingTime());
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
/*        ConsoleHelper.writeMessage("Start cooking - " + order
                + ", cooking time "
                + order.getTotalCookingTime() + "min");
        EventDataRow event = new CookedOrderEventDataRow(order.getTabletName(), name, order.getTotalCookingTime()*60, order.getDishes());
        manager.register(event);*/
        setChanged();
        notifyObservers(order);

        busy = false;
    }

}
