package edu.project1.src;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final int maxAttempts;
    private int userAttemptsCount = 0;
    private final Set<Character> userAnswer = new HashSet<>();
    private final Set<Character> answerLetters;
    private final String answer;

    public Game(int maxAttempts, String answer) {
        this.maxAttempts = maxAttempts;
        this.answer = answer;

        answerLetters = new HashSet<>();
        for (Character letter: answer.toCharArray()) {
            answerLetters.add(letter);
        }
    }

    private Character[] getCurrentAnswer() {
        var result = new Character[answer.length()];

        for (int i = 0; i < answer.length(); i++) {
            var letter = answer.charAt(i);

            if (userAnswer.contains(letter)) {
                result[i] = letter;
            }
        }

        return result;
    }

    private boolean isGameOver() {
        return maxAttempts <= userAttemptsCount;
    }

    IResult guess(char guess) {
        if (userAnswer.contains(guess)) {
            return invalidInput();
        }

        userAnswer.add(guess);

        if (userAnswer.containsAll(answerLetters)) {
            return new IResult.WinResult(userAttemptsCount, maxAttempts, getCurrentAnswer());
        }  else if (answerLetters.contains(guess)) {
            return new IResult.SuccessResult(userAttemptsCount, maxAttempts, getCurrentAnswer());
        }

        userAttemptsCount++;

        if (isGameOver()) {
            return new IResult.LoseResult(userAttemptsCount, maxAttempts, convertAnswerToArray());
        }

        return new IResult.FailResult(userAttemptsCount, maxAttempts, getCurrentAnswer());
    }

    IResult giveUp() {
        return new IResult.LoseResult(userAttemptsCount, maxAttempts, convertAnswerToArray());
    }

    IResult invalidInput() {
        return new IResult.ErrorResult(userAttemptsCount, maxAttempts, getCurrentAnswer());
    }

    private Character[] convertAnswerToArray() {
        return answer.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    }
}
