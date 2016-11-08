package com.volkov;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student1.getAge() - student2.getAge();
    }
}
