package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    private IMF() {
    }

    public static IMF getFund() {
        //add your code here - добавь код тут
        synchronized (Class.class) {
            if (imf == null) {
                imf = new IMF();
            }
            return imf;
        }

    }
}
