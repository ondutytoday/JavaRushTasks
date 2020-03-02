package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch  (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 2; i += 3) {
                        create(args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 3; i += 4) {
                        update(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(args[i]);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        info(args[i]);
                    }
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
            Date birthday = dateFormat.parse(bd);
            switch (sex) {
                case "м":
                    person = Person.createMale(name, birthday);
                    allPeople.add(person);
                    System.out.println((allPeople.size() - 1));
                    break;
                case "ж":
                    person = Person.createFemale(name, birthday);
                    allPeople.add(person);
                    System.out.println((allPeople.size() - 1));
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
        } else {
            throw new IllegalArgumentException("Такого ид не существует");
        }
    }

    public static void delete(String id) {
        int index = Integer.parseInt(id);
        if (index < allPeople.size()) {
            allPeople.get(index).setName(null);
            allPeople.get(index).setBirthDate(null);
            allPeople.get(index).setSex(null);
        } else {
            throw new IllegalArgumentException("Такого ид не существует");
        }
    }

    public static void info(String id) {
        int index = Integer.parseInt(id);
        if (index < allPeople.size()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            if (allPeople.get(index).getSex().equals(Sex.MALE)) {
                System.out.println(allPeople.get(index).getName() + " м " + dateFormat.format(allPeople.get(index).getBirthDate()));
            } else {
                System.out.println(allPeople.get(index).getName() + " ж " + dateFormat.format(allPeople.get(index).getBirthDate()));

            }
        } else {
            throw new IllegalArgumentException("Такого ид не существует");
        }
    }
}
