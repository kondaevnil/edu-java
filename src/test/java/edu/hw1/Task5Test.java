package edu.hw1;

import org.junit.jupiter.api.Test;

import static edu.hw1.Task5.isPalindromeDescendant;
import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {
    @Test
    void Test1() {
        assertTrue(isPalindromeDescendant(11211230));
    }

    @Test
    void Test2() {
        assertTrue(isPalindromeDescendant(13001120));
    }

    @Test
    void Test3() {
        assertTrue(isPalindromeDescendant(23336014));
    }

    @Test
    void Test4() {
        assertTrue(isPalindromeDescendant(11));
    }

    @Test
    void Test5() {
        assertFalse(isPalindromeDescendant(1));
    }

    @Test
    void Test6() {
        assertFalse(isPalindromeDescendant(-1));
    }

    @Test
    void Test7() {
        assertFalse(isPalindromeDescendant(12));
    }

    @Test
    void Test8() {
        assertFalse(isPalindromeDescendant(1211));
    }

    @Test
    void Test9() {
        assertFalse(isPalindromeDescendant(-121));
    }
}
