package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        result.add (new Cat());
        result.add (new Cat());
        result.add (new Cat());
        result.add (new Cat());
        
        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();
        //напишите тут ваш код
        result.add (new Dog());
        result.add (new Dog());
        result.add (new Dog());
        
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> result = new HashSet<Object>();
        //напишите тут ваш код
        for (Cat cat: cats) {
            result.add(cat);
        }
        for (Dog dog: dogs) {
        result.add(dog);
        }
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        Set<Object> petsTemp = new HashSet (pets);
        Iterator <Object> it = petsTemp.iterator();
        while (it.hasNext()) {
            Object pet = it.next();
            for (Cat cat: cats) {
                if (pet.equals(cat)) pets.remove(pet); 
            }
        }
        
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (Object pet: pets) {
            System.out.println(pet);
        }
        
    }

    //напишите тут ваш код
    public static class Cat {
        
    }
    
    public static class Dog {
        
    }
}
