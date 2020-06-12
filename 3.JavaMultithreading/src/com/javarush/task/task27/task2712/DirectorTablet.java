package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private StatisticManager manager = StatisticManager.getInstance();

    public void printAdvertisementProfit() {
        Map<String, Double> map = StatisticManager.getInstance().getAdvStatistic();
        double totalAmount = 0;

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            totalAmount += entry.getValue();
            System.out.println(entry.getKey() + " - " + String.format("%.2f", entry.getValue()));
        }
        System.out.println(String.format("Total - %.2f", totalAmount));

        /*Map<Date, Long> advProfit = manager.getAdvertisementProfit();
*//*
        Date date = new Date();
        date.setTime(45671321354354L);
        advProfit.put(date, 45675L);
        Date date1 = new Date();
        date1.setTime(35626451455L);
        advProfit.put(date1, 675L);
        advProfit.merge(date1, 100L,  (k, v) -> (k+v));
*//*
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double amountTotal = 0;
        System.out.println(advProfit.keySet().toString());
        for (Map.Entry<Date, Long> entry: advProfit.entrySet()) {
            double amount = (double) entry.getValue()/100;
            amountTotal+=amount;
            String ss = String.format(Locale.ENGLISH,"%.2f", amount);
            if (amount > 0) {
                ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()) + " - " + ss);
            }
        }
        String sss = String.format(Locale.ENGLISH,"%.2f", amountTotal);
        ConsoleHelper.writeMessage("Total - " + sss);*/
    }
    public void printCookWorkloading() {

        Map<String, Map<String, Integer>> map = manager.getCookStatistic();

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.println(entry1.getKey() + " - " + entry1.getValue() + " min");
            }
        }
        /*Map<Date, Map<String, Integer>> cookWorkloading = manager.getCookWorkloading();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        for (Map.Entry<Date, Map<String, Integer>> entry: cookWorkloading.entrySet()) {
            ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()));
            for (Map.Entry<String, Integer> ent: entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(ent.getKey() + " - ");
                ConsoleHelper.writeMessage(ent.getValue() + " min");
            }
        }*/
    }

    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet() {

    }
}
