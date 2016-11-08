package com.volkov.figure;

public class Rectangle implements Figure {
    private int sizeA;
    private int sizeB;

    public Rectangle(int sizeA, int sizeB) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
    }


    public int area() {
        return sizeA * sizeB;
    }

    public int perimeter() {
        return 2 * (sizeA + sizeB);
    }
}
