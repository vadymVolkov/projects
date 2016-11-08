package com.volkov.figure;

public class Triangle implements Figure {
    private int sizeA;
    private int sizeB;
    private int sizeC;

    public Triangle(int sizeA, int sizeB, int sizeC) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
    }

    public int area() {
        int perimeter = sizeA + sizeB + sizeC;
        return (int) Math.sqrt(perimeter * (perimeter - sizeA) * (perimeter - sizeB) * (perimeter - sizeC));
    }

    public int perimeter() {
        return sizeA + sizeB + sizeC;
    }
}
