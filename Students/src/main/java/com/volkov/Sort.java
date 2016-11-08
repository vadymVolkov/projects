package com.volkov;

import java.util.Collections;
import java.util.List;

public class Sort {
    public static List<Student> sortStudentByName(List<Student> list) {
        Collections.sort(list);
        return list;
    }

    public static List<Student> sortStudentByAge(List<Student> list) {
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list, ageComparator);
        return list;
    }

    public static List<Student> sortStudentByCityName(List<Student> list) {
        CityNameComparator cityNameComparator = new CityNameComparator();
        Collections.sort(list, cityNameComparator);
        return list;
    }
}
