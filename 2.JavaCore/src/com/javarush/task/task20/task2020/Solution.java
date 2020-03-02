package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private Object readResolve() {
            return new Person(this.firstName, this.lastName,
                    this.country, this.sex);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", greeting='" + greeting + '\'' +
                    ", country='" + country + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }


    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws Exception{
        Person pers1 = new Person("Artem","Geek","Russia",Sex.MALE);
        System.out.println(pers1);
        ByteArrayOutputStream bot = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bot);
        oos.writeObject(pers1);
        ByteArrayInputStream bit = new ByteArrayInputStream(bot.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bit);
        Person pers2 = (Person)ois.readObject();
        System.out.println(pers2);

    }
}
