package com.javarush.task.task07.task0724;                                                                                                    
                                                                                                    
/*                                                                                                     
Семейная перепись                                                                                                    
*/                                                                                                    
                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandpa1 = new Human("Fedor", true, 69);
        Human grandpa2 = new Human("Timophey", true, 75);
        Human grandma1 = new Human("Sofa", false, 73);
        Human grandma2 = new Human("Katya", false, 56);
        Human father = new Human("Sasha", true, 42, grandpa1, grandma1);
        Human mother = new Human("Masha", false, 39, grandpa2, grandma2);
        Human child1 = new Human("Lena", false, 25, father, mother);
        Human child2 = new Human("Dima", true, 18, father, mother);
        Human child3 = new Human("Olya", false, 15, father, mother);

        System.out.println(grandpa1.toString());
        System.out.println(grandpa2.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandma2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }                                                                                 
}