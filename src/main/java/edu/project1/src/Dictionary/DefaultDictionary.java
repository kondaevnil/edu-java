package edu.project1.src.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultDictionary implements IDictionary {
    private final Vector<String> words;
    private final Random random = new Random();
    private String path = "./src/main/java/edu/project1/assets/english.csv";
    private Logger logger = LogManager.getLogger();

    public DefaultDictionary() {
        words = new Vector<>();
        words.add("hello");

        try (BufferedReader reader =
                 new BufferedReader(new FileReader(path))) {
            String line;

            line = reader.readLine();
            String[] headers = Arrays.stream(line.split(",")).filter(i -> i.length() > 1).toArray(String[]::new);
            int numColumns = headers.length;
            words.addAll(Arrays.asList(headers).subList(0, numColumns));

        } catch (IOException e) {
            logger.error(e);
        }
    }

    public DefaultDictionary setFilePath(String path) {
        this.path = path;
        return this;
    }

    public DefaultDictionary setLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public DefaultDictionary buildDictionary() throws IOException {
        try (BufferedReader reader =
                 new BufferedReader(new FileReader(path))) {
            String line;

            line = reader.readLine();
            String[] headers = Arrays.stream(line.split(",")).filter(i -> i.length() > 1).toArray(String[]::new);
            int numColumns = headers.length;
            words.addAll(Arrays.asList(headers).subList(0, numColumns));

        } catch (IOException e) {
            logger.error(e);
            throw e;
        }

        return this;
    }

    @Override
    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}
