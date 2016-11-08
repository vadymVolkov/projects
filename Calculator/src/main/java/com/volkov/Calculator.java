package com.volkov;

public class Calculator {

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        System.out.println(add(x,y));

    }

    public static int add(int operand1, int operand2) {
        return operand1 + operand2;
    }
    public static int add() {
        return 0;
    }
    public static int add(int operand1) {
        return operand1;
    }
}
