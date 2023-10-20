package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task8.knightBoardCapture;
import static org.junit.jupiter.api.Assertions.*;

public class Task8Test {
    @Test
    void Test1() {
        assertTrue(knightBoardCapture(new int[][] {
            { 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0 }
        }));
    }

    @Test
    void Test2() {
        assertFalse(knightBoardCapture(new int[][] {
            { 1, 0, 1, 0, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 1, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 1, 0, 1, 0 },
            { 0, 0, 0, 1, 0, 1, 0, 1 }
        }));
    }

    @Test
    void Test3() {
        assertFalse(knightBoardCapture(new int[][] {
            { 0, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0 }
        }));
    }
}
