package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task7.rotateRight;
import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {
    @Test
    void Test1() {
        assertEquals(4, rotateRight(8, 1));
    }

    @Test
    void Test2() {
        assertEquals(1, rotateLeft(16, 1));
    }

    @Test
    void Test3() {
        assertEquals(6, rotateLeft(17, 2));
    }

    @Test
    void Test4() {
        assertEquals(0, rotateLeft(0, 100));
    }

    @Test
    void Test5() {
        assertEquals(1, rotateLeft(1, 100));
    }

    @Test
    void Test6() {
        assertEquals(0, rotateRight(0, 100));
    }

    @Test
    void Test7() {
        assertEquals(0b1111, rotateRight(0b1111, 10));
    }

    @Test
    void Test8() {
        assertEquals(0b0101, rotateRight(0b1010, 1));
    }
}
