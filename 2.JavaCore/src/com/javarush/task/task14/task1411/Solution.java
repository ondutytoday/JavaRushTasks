package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        boolean isEnd = false;

        //тут цикл по чтению ключей, пункт 1
        while (!isEnd) {
            switch (reader.readLine()) {
                case ("user"):
                    Person.User user = new Person.User();
                    doWork(user);
                    break;
                case ("loser"):
                    Person.Loser loser = new Person.Loser();
                    doWork(loser);
                    break;
                case ("coder"):
                    Person.Coder coder = new Person.Coder();
                    doWork(coder);
                    break;
                case ("proger"):
                    Person.Proger proger = new Person.Proger();
                    doWork(proger);
                    break;
                default:
                    isEnd = true;
                    break;
            }

        }
    }

    public static void doWork(Person person) {
            if (person instanceof Person.User) {
                ((Person.User) person).live();
            } else if (person instanceof Person.Loser) {
                ((Person.Loser) person).doNothing();
            } else if (person instanceof Person.Coder) {
                ((Person.Coder) person).writeCode();
            } else if (person instanceof Person.Proger) {
                ((Person.Proger) person).enjoy();
            }


    }
}
