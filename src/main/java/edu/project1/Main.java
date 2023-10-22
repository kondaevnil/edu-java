package edu.project1;

import edu.project1.src.Hangman;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Hangman.getInstance().run();
    }
}
