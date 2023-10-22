package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    static Task2 task2 = new Task2();

    @Test
    void squareTest() {
        var square = task2.new Square(10);
        assertEquals(10, square.getHeight());
        assertEquals(10, square.getWidth());
    }

    @Test
    void squareChangeTest() {
        var square = task2.new Square(10).setSide(20);
        assertEquals(20, square.getHeight());
        assertEquals(20, square.getWidth());
    }

    @Test
    void squareCastToRectangleTest() {
        Task2.Rectangle rectangle = task2.new Square(10).setHeight(20);
        assertEquals(20, rectangle.getHeight());
        assertEquals(10, rectangle.getWidth());
    }

    @Test
    void squareCastToRectangleAreaTest() {
        Task2.Rectangle rectangle = task2.new Square(10).setHeight(20);
        assertEquals(200, rectangle.area());
    }
}
