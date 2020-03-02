package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 32;
    }

    @Override
    public String getDescription() {
        String s = String.format("%s Моя страна - %s. Я несу %s яиц в месяц.",
                super.getDescription(), Country.UKRAINE, this.getCountOfEggsPerMonth());
        return  s;
    }
}
