package com.javarush.task.task25.task2502;

import java.util.Arrays;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws IllegalArgumentException{
            //init wheels here

                String[] s = loadWheelNamesFromDB();
                if (s.length != 4) throw new IllegalArgumentException();
                wheels = Arrays.asList(Wheel.valueOf(s[0]),
                        Wheel.valueOf(s[1]), Wheel.valueOf(s[2]),
                        Wheel.valueOf(s[3]));

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
