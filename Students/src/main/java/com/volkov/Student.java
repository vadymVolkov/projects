package com.volkov;


class Student implements Comparable<Student> {
    private String name;
    private int age;
    private City city;

    Student(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student name: " + name + "\n" + "Student age: " + age + "\n" + "Student live in: " + city + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != Student.class) return false;

        Student student = (Student) o;

        if (this.name == null) return false;

        boolean nameResult = this.name.equals(student.name);
        boolean ageResult = this.age == student.age;
        boolean city = this.city == student.city;
        return nameResult && ageResult && city;
    }


}
