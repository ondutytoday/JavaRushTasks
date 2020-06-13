package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order{

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        List<Dish> dishesRandom = new ArrayList<>( (int) (Math.random() * Dish.values().length) + 3);
        int n = Dish.values().length;
        for (int i = 0; i < dishesRandom.size(); i++) {
            dishesRandom.add(Dish.values()[(int) Math.random()*n]);
        }
        super.dishes = dishesRandom;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
