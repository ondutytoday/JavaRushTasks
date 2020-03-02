package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private int height;
        private long passport;
        private String city;
        private String country;

        public Human() {
            this.name = "bomg kakoyto";
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public Human(String name, int age, int height, long passport, String city) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.passport = passport;
            this.city = city;
        }

        public Human(String name, int age, int height, long passport) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.passport = passport;
        }

        public Human(String name, int age, int height, long passport, String city, String country) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.passport = passport;
            this.city = city;
            this.country = country;
        }

        public Human(String name, String city, String country) {
            this.name = name;
            this.city = city;
            this.country = country;
        }

        public Human(String name, long passport) {
            this.name = name;
            this.passport = passport;
        }

        public Human(long passport, String city, String country) {
            this.passport = passport;
            this.city = city;
            this.country = country;
        }
    }
}
