package edu.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    void test() throws Exception {
        Assertions.assertDoesNotThrow(() -> {
            Task4.callingInfo();
        });
    }
}
