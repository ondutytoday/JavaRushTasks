package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return students
                .stream()
                .filter(student -> averageGrade == student.getAverageGrade())
                .findAny()
                .get();

    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return students
                .stream()
                .max((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()))
                .get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        return students
                .stream()
                .min(Comparator.comparingDouble(Student::getAverageGrade))
                .get();
    }

    public void expel (Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}