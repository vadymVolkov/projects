package com.volkov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        City newyork = new City("New York", 112, 314);
        City washington = new City("Washington", 115, 678);
        City detroit = new City("Detroit", 193, 134);


        Student bob = new Student("Bob", 13, newyork);
        Student tom = new Student("Tom", 18, washington);
        Student rick = new Student("Rick", 21, detroit);
        Student jack = new Student("Jack", 21, newyork);
        Student rita = new Student("Rita", 48, washington);

        List<Student> list = new ArrayList<Student>();
        list.add(rick);
        list.add(bob);
        list.add(tom);
        list.add(rita);
        list.add(jack);

        System.out.println("Сортировка по имени: " + Sort.sortStudentByName(list));
        System.out.println("Сортировка по возрасту: " + Sort.sortStudentByAge(list));
        System.out.println("Сортировка по городу проживания: " + Sort.sortStudentByCityName(list));

    }
}
