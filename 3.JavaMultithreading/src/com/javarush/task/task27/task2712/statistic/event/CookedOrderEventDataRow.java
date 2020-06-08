package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow{
    //имя планшета
    private String tabletName;
    //имя повара
    private String cookName;
    //время приготовления заказа в секундах
    private int cookingTimeSeconds;
    //список блюд для приготовления
    private List<Dish> cookingDishs;
    private Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();
    }
}
