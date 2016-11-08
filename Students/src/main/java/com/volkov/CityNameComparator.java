package com.volkov;

import java.util.Comparator;

public class CityNameComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        if (student1.getCity().getName().equals(student2.getCity().getName())) {
            return 0;
        }
        return student1.getCity().getName().compareTo(student2.getCity().getName());
    }
}
