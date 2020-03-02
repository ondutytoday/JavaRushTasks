package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandpa1 = new Human ("Valera", true, 79);
        Human grandma1 = new Human("Masha", false, 78);
        Human grandpa2 = new Human ("Vitya", true, 71);
        Human grandma2 = new Human("Katya", false, 75);
        Human father = new Human("Platon", true, 40);
        Human mother = new Human("Kuzelbek", false, 49);
        Human child1 = new Human("Pavlik", true, 7);
        Human child2 = new Human ("Hose", false, 12);
        Human child3 = new Human("Olya", false, 24);

        father.children.add(child3);
        father.children.add(child2);
        father.children.add(child1);
        mother.children.add(child3);
        mother.children.add(child2);
        mother.children.add(child1);
        grandma1.children.add(mother);
        grandpa1.children.add(mother);
        grandma2.children.add(father);
        grandpa2.children.add(father);

        System.out.println(grandpa1.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandpa2.toString());
        System.out.println(grandma2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }




        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
