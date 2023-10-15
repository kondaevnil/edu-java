package edu.hw1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static edu.hw1.Task1.minutesToSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void SuccessTest1() {
         assertEquals(new BigInteger("60"), minutesToSeconds("01:00"));
    }

    @Test
    void SuccessTest2() {
        assertEquals(new BigInteger("836"), minutesToSeconds("13:56"));
    }

    @Test
    void SuccessTest3() {
        assertEquals(new BigInteger("0"), minutesToSeconds("00:00"));
    }

    @Test
    void SuccessTest4() {
        assertEquals(new BigInteger("59"), minutesToSeconds("00:59"));
    }

    @Test
    void FailureTest1() {
        assertEquals(new BigInteger("-1"), minutesToSeconds("10:60"));
    }

    @Test
    void FailureTest2() {
        assertEquals(new BigInteger("-1"), minutesToSeconds(""));
    }

    @Test
    void FailureTest3() {
        assertEquals(new BigInteger("-1"), minutesToSeconds("10"));
    }

    @Test
    void FailureTest4() {
        assertEquals(new BigInteger("-1"), minutesToSeconds("10:60:0"));
    }

    @Test
    void FailureTest5() {
        assertEquals(new BigInteger("-1"), minutesToSeconds("70:70"));
    }

    @Test
    void FailureTest6() {
        assertEquals(new BigInteger("-1"), minutesToSeconds("oo:oo"));
    }

    @Test
    void FailureTest7() {
        assertEquals(new BigInteger("-1"), minutesToSeconds("-10:60"));
    }
}
