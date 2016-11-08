package com.volkov;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortTest {
    City newyork;
    City detroit;
    Student bob;
    Student rick;
    List<Student> list;

    @Before
    public void setUp() {
        newyork = new City("New York", 112, 314);
        detroit = new City("Detroit", 193, 134);

        rick = new Student("Rick", 21, newyork);
        bob = new Student("Bob", 13, detroit);

        list = new ArrayList<Student>();
        list.add(rick);
        list.add(bob);

    }

    @Test
    public void sortStudentByNameTest() {
    Sort.sortStudentByName(list);
        assertThat(list.get(0).getName(),is("Bob"));
    }

    @Test
    public void sortStudentByAgeTest() {
        Sort.sortStudentByAge(list);
        assertThat(list.get(0).getAge(),is(13));
    }
    @Test
    public void sortStudentByCityNameTest() {
        Sort.sortStudentByAge(list);
        assertThat(list.get(0).getCity().getName(),is("Detroit"));
    }
}
