package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    public String getDescription() {
        String s = String.format("%s Моя страна - %s. Я несу %s яиц в месяц.",
                super.getDescription(), Country.BELARUS, this.getCountOfEggsPerMonth());
        return  s;
    }
}
