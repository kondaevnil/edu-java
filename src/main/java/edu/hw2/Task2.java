package edu.hw2;

public class Task2 {
    public class Rectangle {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        final Rectangle setWidth(double width) {
            return new Rectangle(width, height);
        }

        final Rectangle setHeight(double height) {
            return new Rectangle(width, height);
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        double area() {
            return width * height;
        }
    }

    public class Square extends Rectangle {
        public Square(double side) {
            super(side, side);
        }

        final public Square setSide(double side) {
            return new Square(side);
        }
    }
}
