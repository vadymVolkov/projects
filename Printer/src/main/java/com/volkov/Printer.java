package com.volkov;

public class Printer {
    String company;
    String color;
    String feature;
    int paperCapacity;
    int speed;
    int cartridge;

    Printer(String company, String color, String feature, int paperCapacity, int speed, int cartridge) {
        this.company = company;
        if (color.equals("Black") || color.equals("White")) {
            this.color = color;
        }
        else {
            System.out.println("Wrong color");
        }
        if (feature.equals("MultyColor") || feature.equals("TwoColor")) {
            this.feature = feature;
        }
        else {
            System.out.println("Wrong feature");
        }
        if (paperCapacity>50 && paperCapacity<500) {
            this.paperCapacity = paperCapacity;
        }
        else {
            System.out.println("Wrong paperCapacity");
        }
        if (speed>10 && speed<100) {
            this.speed = speed;
        }
        else {
            System.out.println("Wrong speed");
        }
        if ((cartridge==1 && feature.equals("TwoColor")) || (cartridge==2 && feature.equals("MultyColor"))) {
            this.cartridge = cartridge;
        }
        else {
            System.out.println("Cartrige is wrong");
        }

    }
}
