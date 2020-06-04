package com.javarush.task.task27.task2712.kitchen;

import java.util.StringJoiner;

public enum Dish {
    Fish (25),
    Steak (30),
    Soup (15),
    Juice (5),
    Water (3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Dish dish : Dish.values()) {
            joiner.add(dish.toString());
        }
        return joiner.toString();
    }
}
