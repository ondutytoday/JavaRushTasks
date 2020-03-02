package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static void main(String[] args) throws Exception {

        File file = new File("1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        Person personOne = new Person("Vasya", "Vasilev", 32);
        personOne.setMother(new Person("mom", "sdfs", 34));
        personOne.setFather(new Person("dad", "asfds", 56));
        personOne.setChildren(Arrays.asList(new Person("child1", "fdds", 12),
                new Person("child2", "fdds", 18)));
        personOne.writeExternal(oos);
        System.out.println(personOne);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person personTwo = new Person();
        personTwo.readExternal(ois);
        System.out.println(personTwo);
        ois.close();

    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            father = (Person) in.readObject();
            mother = (Person) in.readObject();
            age = in.readInt();
            children = (List) in.readObject();

        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", mother=" + mother +
                    ", father=" + father +
                    ", children=" + children +
                    '}';
        }
    }
}
