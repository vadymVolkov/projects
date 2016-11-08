package com.volkov.figure;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FigureMaineTest {
    Figure figureTriangle;
    Figure figureRectangle;

    @Before
    public void setUp() {
        figureTriangle = new Triangle(1, 2, 3);
        figureRectangle = new Rectangle(7, 8);
    }

    @Test
    public void peremetrTriangleTest() {
        int perimetr = figureTriangle.perimeter();
        assertThat(perimetr, is(6));
    }

    @Test
    public void areaTriangleTest() {
        int area = figureTriangle.area();
        assertThat(area, is(18));
    }

    @Test
    public void peremetrRectangleTest() {
        int perimetr = figureRectangle.perimeter();
        assertThat(perimetr, is(30));
    }

    @Test
    public void areaRectangleTest() {
        int area = figureRectangle.area();
        assertThat(area, is(56));
    }

}
