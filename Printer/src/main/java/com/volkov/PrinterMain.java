package com.volkov;

public class PrinterMain {
    public static void main(String[] args) {
        Printer printer1 = new Printer("HP", "Black", "MultyColor", 100, 50, 2);
        System.out.println(printer1.company);
        System.out.println(printer1.color);
        System.out.println(printer1.feature);
        System.out.println(printer1.paperCapacity);
        System.out.println(printer1.speed);
        System.out.println(printer1.cartridge);
    }
}
