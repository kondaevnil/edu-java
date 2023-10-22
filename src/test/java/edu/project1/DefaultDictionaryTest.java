package edu.project1;

import edu.project1.src.Dictionary.DefaultDictionary;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultDictionaryTest {
    @Test
    void fileNotExistTest() throws IOException {
        assertThrows(IOException.class, () -> new DefaultDictionary().setFilePath("./").buildDictionary());
    }

    @Test
    void emptyFileTest() {
        final var getWordAttempts = 1000;
        assertDoesNotThrow(() -> {
            var dict = new DefaultDictionary()
                .setFilePath("src/test/java/edu/project1/sample/emty-file-test")
                .buildDictionary();

            for (var i = 0; i < getWordAttempts; i++) {
                assertFalse(dict.getRandomWord().isEmpty());
            }
        });
    }
}
