package com.volkov.figure;

public class FigureMain {
    public static void main(String[] args) {
        /*
        Figure triangle = new Triangle(3,4,5);
        triangle.perimeter();
        triangle.area();
        triangle.info();
        Figure rectangle = new Rectangle(3,4);
        rectangle.perimeter();
        rectangle.area();
        */

        Figure[] figures = new Figure[]{new Triangle(1, 2, 3), new Triangle(4, 5, 6), new Rectangle(7, 8), new Rectangle(9, 10)};
        int count = 1;
        for (Figure figure : figures) {
            System.out.println("Фигура номер " + count);
            System.out.println("Площадь фигуры " + figure.area());
            System.out.println("Периметр фигуры " + figure.perimeter());
            count++;
        }
        if ( 1 > 0 ? false : true) {
            System.out.println(true);
        }
            else {
            System.out.println(false);
            }

    }


}
