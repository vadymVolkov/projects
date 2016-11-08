package com.volkov;

public class LanternMain {
    public static void main(String[] args) {
        Lantern lantern1 = new Lantern("BigBen", 3,8, "red");
        System.out.println(lantern1.name);
        System.out.println(lantern1.batteryCapacity);
        System.out.println(lantern1.batteryInside);
        System.out.println(lantern1.color);
        System.out.println(lantern1.feature);
        lantern1.putInBattery();
        lantern1.putInBattery();
        System.out.println(lantern1.batteryInside);
        lantern1.takeOutBattery();
        System.out.println(lantern1.batteryInside);
    }
}
