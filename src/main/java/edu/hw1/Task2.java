package edu.hw1;

public class Task2 {
    public static int countDigits(int n) {
        if (n == 0)
            return 1;

        var counter = 0;
        while (n != 0) {
            n /= 10;
            counter++;
        }

        return counter;
    }
}
