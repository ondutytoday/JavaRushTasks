package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        String s = "";
        List<Dish> list = new ArrayList<>();
        do {
            writeMessage("Please choose the dish or type Exit for exit");
            s = readString();
            int listSize = list.size();
            for (Dish dish : Dish.values() ) {
                if (dish.toString().equalsIgnoreCase(s)) {
                    list.add(dish);
                }
            }
            if (listSize == list.size() && !s.equalsIgnoreCase("exit")) {
                writeMessage("There is no such dish on the menu");
            }
        } while (!s.equalsIgnoreCase("exit"));

        return list;
    }
}
