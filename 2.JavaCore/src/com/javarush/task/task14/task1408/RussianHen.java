package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 30;
    }

    @Override
    public String getDescription() {
        String s = String.format("%s Моя страна - %s. Я несу %s яиц в месяц.",
                super.getDescription(), Country.RUSSIA, this.getCountOfEggsPerMonth());
        return  s;
              //  "Я несу яйца во славу Путена";
    }
}
