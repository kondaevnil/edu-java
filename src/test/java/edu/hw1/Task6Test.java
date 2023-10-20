package edu.hw1;

import org.junit.jupiter.api.Test;

import static edu.hw1.Task6.countK;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {
    @Test
    void Test1() {
        assertEquals(5, countK(6621));
    }

    @Test
    void Test2() {
        assertEquals(4, countK(6554));
    }

    @Test
    void Test3() {
        assertEquals(3, countK(1234));
    }

    @Test
    void Test4() {
        assertEquals(0, countK(6174));
    }
}
