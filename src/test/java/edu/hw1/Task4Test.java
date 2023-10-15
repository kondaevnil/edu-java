package edu.hw1;

import org.junit.jupiter.api.Test;

import static edu.hw1.Task4.fixString;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {
    @Test
    void Test1() {
        assertEquals("214365", fixString("123456"));
    }

    @Test
    void Test2() {
        assertEquals("This is a mixed up string.", fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    void Test3() {
        assertEquals("abcde", fixString("badce"));
    }

    @Test
    void Test4() {
        assertEquals("1", fixString("1"));
    }

    @Test
    void Test5() {
        assertEquals("", fixString(""));
    }

    @Test
    void Test6() {
        assertEquals("0 0", fixString(" 00"));
    }
}
