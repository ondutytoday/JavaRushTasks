package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                if (args.length == 4) {
                    create(args[1], args[2], args[3]);
                }
                break;
            case "-u":
                if (args.length == 5) {
                    update(args[1], args[2], args[3], args[4]);
                }
                break;
            case "-d":
                if (args.length == 2) {
                    delete(args[1]);
                }
                break;
            case "-i":
                if (args.length == 2) {
                    info(args[1]);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid command");
        }

    }

    public static void create(String name, String sex, String bd) {
        Person person;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date birthday= dateFormat.parse(bd);
            switch (sex) {
                case "м":
                    person = Person.createMale(name, birthday);
                    allPeople.add(person);
                    System.out.println((allPeople.size()-1));
                    break;
                case "ж":
                    person = Person.createFemale(name, birthday);
                    allPeople.add(person);
                    System.out.println((allPeople.size()-1));
                    break;
                default:
                    throw new IllegalArgumentException("Такого пола не существует");
            }
        } catch (ParseException e) {
            System.out.println("Wrong dateformat!");
        }

    }

    public static void update(String id, String name, String sex, String bd) {
        int index = Integer.parseInt(id);
        if (index < allPeople.size()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try {
                Date birthday = dateFormat.parse(bd);
                switch (sex) {
                    case "м":
                        allPeople.get(index).setName(name);
                        allPeople.get(index).setBirthDate(birthday);
                        allPeople.get(index).setSex(Sex.MALE);
                        break;
                    case "ж":
                        allPeople.get(index).setName(name);
                        allPeople.get(index).setBirthDate(birthday);
                        allPeople.get(index).setSex(Sex.FEMALE);
                        break;
                    default:
                        throw new IllegalArgumentException("Такого пола не существует");
                }
            } catch (ParseException e) {
                System.out.println("Wrong dateformat!");
            }
        }
        else {
            throw new IllegalArgumentException("Такого ид не существует");
        }
    }

    public static void delete (String id) {
        int index = Integer.parseInt(id);
        allPeople.get(index).setName(null);
        allPeople.get(index).setBirthDate(null);
        allPeople.get(index).setSex(null);
    }

    public static void info (String id) {
        int index = Integer.parseInt(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (allPeople.get(index).getSex().equals(Sex.MALE)) {
            System.out.println(allPeople.get(index).getName() + " м " + dateFormat.format(allPeople.get(index).getBirthDate()));
        }
        else {
            System.out.println(allPeople.get(index).getName() + " ж " + dateFormat.format(allPeople.get(index).getBirthDate()));

        }
    }
}
