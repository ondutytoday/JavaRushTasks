package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    private StatisticManager manager = StatisticManager.getInstance();

    public void printAdvertisementProfit() {
        Map<Date, Long> advProfit = manager.getAdvertisementProfit();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        double amountTotal = 0;
        for (Map.Entry<Date, Long> entry: advProfit.entrySet()) {
            double amount = (double) (entry.getValue()/100);
            amountTotal+=amount;
            ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()));
            ConsoleHelper.writeMessage(" - " + amount);
        }
        ConsoleHelper.writeMessage("Total - " + amountTotal);
    }
    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloading = manager.getCookWorkloading();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        for (Map.Entry<Date, Map<String, Integer>> entry: cookWorkloading.entrySet()) {
            ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()));
            for (Map.Entry<String, Integer> ent: entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(ent.getKey() + " - ");
                ConsoleHelper.writeMessage(ent.getValue() + " min");
            }
        }
    }

    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet() {

    }
}
