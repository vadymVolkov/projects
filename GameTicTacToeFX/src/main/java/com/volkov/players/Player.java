package com.volkov.players;

public abstract class Player {

    private String name;
    private int age;
    private char type;
    private int wins;
    private int lose;
    private String brain;

    public Player(String name, int age, char type, int wins, int lose, String brain) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.wins = wins;
        this.lose = lose;
        this.brain=brain;
    }

    public String getBrain() {
        return brain;
    }

    public void setBrain(String brain) {
        this.brain = brain;
    }

    public char getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
}

