package com.volkov;

public class Lantern {
    String name;
    int batteryInside;
    int batteryCapacity;
    String color;
    String feature;

    Lantern(String name, int batteryCapacity, int batteryInside, String color, String feature) {
        this.name = name;
        if (batteryCapacity > 0 && batteryCapacity < 4) {
            this.batteryCapacity = batteryCapacity;
        } else {
            System.out.println("Wrong number of battery capacity");
        }
        if (batteryInside > 0 && (batteryInside < batteryCapacity || batteryInside == batteryCapacity)) {
            this.batteryInside = batteryInside;
        } else {
            System.out.println("Wrong number of battery");
        }
        if (feature.equals("flashing") || feature.equals("No extra feature") ) {
            this.feature = feature;
        } else {
            System.out.println("This feature is not available");
        }
        if (color.equals("white") || color.equals("red")) {
            this.color = color;
        } else {
            System.out.println("This color is not available");
        }
        if ((color.equals("white") && batteryInside < 1) || (color.equals("red") && batteryInside < 2) || (feature.equals("flashing") && batteryInside < 3)) {
            System.out.println("You need more battery");
        }
    }
    Lantern(String name, int batteryCapacity, int batteryInside, String color ) {
        this(name, batteryCapacity, batteryInside, color, "No extra feature");

    }

    void putInBattery() {
        if (batteryInside < batteryCapacity) {
            batteryInside++;
        } else {
            System.out.println("Not enough space");
        }
    }

    void takeOutBattery() {
        if (batteryInside > 0) {
            batteryInside--;
        } else {
            System.out.println("It is empty");
        }
    }
}
