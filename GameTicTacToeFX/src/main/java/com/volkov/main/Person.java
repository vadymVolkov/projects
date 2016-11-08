package com.volkov.main;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Person {
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleIntegerProperty age = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty wins = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty lose = new SimpleIntegerProperty(0);

    public Person() {
        this("", 0, 0, 0);
    }

    public Person(String name, int age, int wins, int lose) {
        setName(name);
        setAge(age);
        setWins(wins);
        setLose(lose);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String data) {
        name.set(data);
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int data) {
        age.set(data);
    }

    public int getWins() {
        return wins.get();
    }

    public void setWins(int data) {
        wins.set(data);
    }

    public int getLose() {
        return lose.get();
    }

    public void setLose(int data) {
        lose.set(data);
    }
}