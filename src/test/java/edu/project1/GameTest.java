package edu.project1;

import edu.project1.src.Game;
import edu.project1.src.IResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    @Test
    void loseResultAfterMaxAttemptsTest() {
        final var maxAttempts = 10;
        final var takeChars = new char[] {'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'};

        assertEquals(takeChars.length, maxAttempts);

        var game = new Game(maxAttempts, "abcdefg");
        IResult result;

        for (var i = 0; i < maxAttempts; i++) {
            result = game.guess(takeChars[i]);
            assertEquals(result.userAttempts(), i + 1);
            assertEquals(result.maxAttempts(), maxAttempts);

            if (result.userAttempts() >= maxAttempts) {
                assertFalse(result.isGameRunning());
                assertEquals("You Lost!", result.message());
            } else {
                assertTrue(result.isGameRunning());
            }
        }
    }

    @ParameterizedTest
    @ValueSource(chars = {'e', 'h', 'l', 'o'})
    void successResultAfterCorrectAnswerTest(char input) {
        final var word = "hello";
        final var game = new Game(1, word);

        var result = game.guess(input);
        assertTrue(result.isGameRunning());
        assertEquals(0, result.userAttempts());
        assertEquals("Hit!", result.message());
    }

    @ParameterizedTest
    @ValueSource(chars = {' ', '0', '.', ','})
    void errorResultTest(char input) {
        final var word = "hello";
        final var game = new Game(1, word);

        var result = game.guess(input);
        assertTrue(result.isGameRunning());
        assertEquals(0, result.userAttempts());
        assertEquals("Invalid string: given more than 1 symbol, empty string or given symbol was already used."
            , result.message());
    }

    @Test
    void oneLetterFewTimesTest() {
        final var game = new Game(2, "answer");
        game.guess('a');

        for (var i = 0; i < 100; i++) {
            var res = game.guess('a');
            assertTrue(res.isGameRunning());
            assertEquals("Invalid string: given more than 1 symbol, empty string or given symbol was already used.",
                res.message());
        }
    }

    @Test
    void failResultTest() {
        final var word = "zucchini";
        final var attemptsCount = 100;
        final var game = new Game(attemptsCount, word);

        var i = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!word.contains(String.valueOf(ch))) {
                var res = game.guess(ch);
                assertEquals(String.format("Missed, mistake %d out of %d", i, attemptsCount), res.message());
                i++;
            }
        }
    }
}
