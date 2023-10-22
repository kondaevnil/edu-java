package edu.project1.src;

public interface IResult {
    String message();
    int maxAttempts();
    int userAttempts();
    Character[] guessWordState();
    boolean isGameRunning();

    record WinResult(int userAttempts, int maxAttempts, Character[] userAnswer) implements IResult {

        @Override
        public String message() {
            return "You won!";
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public int userAttempts() {
            return userAttempts;
        }

        @Override
        public Character[] guessWordState() {
            return userAnswer;
        }

        @Override
        public boolean isGameRunning() {
            return false;
        }
    }

    record LoseResult(int userAttempts, int maxAttempts, Character[] userAnswer) implements IResult {

        @Override
        public String message() {
            return "You Lost!";
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public int userAttempts() {
            return userAttempts;
        }

        @Override
        public Character[] guessWordState() {
            return userAnswer;
        }

        @Override
        public boolean isGameRunning() {
            return false;
        }
    }

    record SuccessResult(int userAttempts, int maxAttempts, Character[] correctWord) implements IResult {
        @Override
        public String message() {
            return "Hit!";
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public int userAttempts() {
            return userAttempts;
        }

        @Override
        public Character[] guessWordState() {
            return correctWord;
        }

        @Override
        public boolean isGameRunning() {
            return true;
        }
    }

    record FailResult(int userAttempts, int maxAttempts, Character[] correctWord) implements IResult {
        @Override
        public String message() {
            return String.format("Missed, mistake %d out of %d", userAttempts, maxAttempts);
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public int userAttempts() {
            return userAttempts;
        }

        @Override
        public Character[] guessWordState() {
            return correctWord;
        }

        @Override
        public boolean isGameRunning() {
            return true;
        }
    }

    record ErrorResult(int userAttempts, int maxAttempts, Character[] userAnswer) implements IResult {
        @Override
        public String message() {
            return "Invalid string: given more than 1 symbol, empty string or given symbol was already used.";
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public int userAttempts() {
            return userAttempts;
        }

        @Override
        public Character[] guessWordState() {
            return userAnswer;
        }

        @Override
        public boolean isGameRunning() {
            return true;
        }
    }
}
