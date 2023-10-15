package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void Test1() {
        assertEquals(1, countDigits(0));
    }

    @Test
    void Test2() {
        assertEquals(1, countDigits(-1));
    }

    @Test
    void Test3() {
        assertEquals(3, countDigits(100));
    }

    @Test
    void Test4() {
        assertEquals(1, countDigits(1));
    }

    @Test
    void Test5() {
        assertEquals(4, countDigits(9999));
    }

    @Test
    void Test6() {
        assertEquals(2, countDigits(-10));
    }
}
