package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
        this(new ArrayList<>());
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("\uD83D\uDC0E", 3, 0);
        Horse horse2 = new Horse("Borya", 3, 0);
        Horse horse3 = new Horse("Zorka", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run();
        game.printWinner();


    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {

        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();


    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}
