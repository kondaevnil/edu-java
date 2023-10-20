package edu.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task3Test {
    static Task3 task3 = new Task3();

    @Test
    void faultyConnectionTest() {
        var faulty = task3.new FaultyConnection();

        Assertions.assertThrows(Task3.ConnectionException.class, () -> {
           while (true) {
               faulty.execute("");
           }
        });
    }

    @Test
    void defaultManagerTest() {
        var manager = task3.new DefaultConnectionManager();
        var attemptCount = 1000;

        Assertions.assertThrows(Task3.ConnectionException.class, () -> {
            while (true) {
                var connection = manager.getConnection();
                for (var i = 0; i < attemptCount; i++) {
                    connection.execute("");
                }
            }
        });
    }

    @Test
    void faultyManagerTest() {
        var connection = task3.new FaultyConnectionManager().getConnection();

        Assertions.assertThrows(Task3.ConnectionException.class, () -> {
            while (true) {
                connection.execute("");
            }
        });
    }
}
