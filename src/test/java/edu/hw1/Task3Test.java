package edu.hw1;

import org.junit.jupiter.api.Test;

import static edu.hw1.Task3.isNestable;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {
    @Test
    void Test1() {
        assertTrue(isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
    }

    @Test
    void Test2() {
        assertTrue(isNestable(new int[] {3, 1}, new int[] {4, 0}));
    }

    @Test
    void Test3() {
        assertFalse(isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
    }

    @Test
    void Test4() {
        assertFalse(isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }
}
