package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    //в минктах
    public int getTotalCookingTime() {
        int n = dishes.stream().mapToInt(Dish::getDuration).sum();
        return n;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public String getTabletName() {
        return tablet.toString();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        } else {
            return "Your order: " + dishes + " of " + tablet;
        }
    }
}
