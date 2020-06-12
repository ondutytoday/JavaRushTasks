package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private final int interval;
    private List<Tablet> tabletList;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int interval) {
        this.tabletList = tabletList;
        this.interval = interval;
    }

    @Override
    public void run() {
        Tablet testTablet = tabletList.get((int) (Math.random() * tabletList.size()));
        testTablet.createTestOrder();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
