package edu.project1.src.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import org.apache.logging.log4j.Logger;

public class DefaultDictionary implements IDictionary {
    private final Vector<String> words;
    private final Random random = new Random();

    public DefaultDictionary(Logger logger) {
        words = new Vector<>();
        words.add("hello");

        try (BufferedReader reader =
                 new BufferedReader(new FileReader("./src/main/java/edu/project1/assets/english.csv"))) {
            String line;

            line = reader.readLine();
            String[] headers = line.split(",");
            int numColumns = headers.length;
            words.addAll(Arrays.asList(headers).subList(0, numColumns));

        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}
