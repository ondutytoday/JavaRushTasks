package com.javarush.task.task27.task2712.kitchen;

import java.util.StringJoiner;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Dish dish : Dish.values()) {
            joiner.add(dish.toString());
        }
        return joiner.toString();
    }
}
