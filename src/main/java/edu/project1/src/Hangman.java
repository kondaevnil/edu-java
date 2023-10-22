package edu.project1.src;

import edu.project1.src.Dictionary.DefaultDictionary;
import edu.project1.src.Dictionary.IDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hangman {
    private final static Logger LOGGER = LogManager.getLogger();
    BufferedReader reader;
    IDictionary dictionary;
    private final int attemptsCount = 8;

    private Hangman() {
        reader = new BufferedReader(
            new InputStreamReader(System.in));
        dictionary = new DefaultDictionary(LOGGER);
    }

    private static final class HangmanHolder {
        private static final Hangman INSTANCE = new Hangman();
    }

    public static Hangman getInstance() {
        return HangmanHolder.INSTANCE;
    }

    public void run() {
        var game = new Game(attemptsCount, dictionary.getRandomWord());
        var isRun = true;

        while (isRun) {
            printRoundMessage();

            try {
                var input = reader.readLine();
                var result = tryGuess(game, input);

                printState(result);

                isRun = result.isGameRunning();
            } catch (IOException e) {

            }
        }
    }

    private IResult tryGuess(Game game, String input) {
        if (input == null || input.equals("over")) {
            return game.giveUp();
        }

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            return game.invalidInput();
        }

        return game.guess(Character.toLowerCase(input.charAt(0)));
    }

    private void printState(IResult guess) {
        System.out.println(guess.message());
        System.out.println();
        System.out.print("The word: ");

        for (var i = 0; i < guess.guessWordState().length; i++) {
            var letter = guess.guessWordState()[i];

            if (letter != null) {
                System.out.print(letter);
            } else {
                System.out.print('*');
            }
        }

        System.out.println("\n");
    }

    private void printRoundMessage() {
        System.out.println("Guess a letter:");
    }
}
