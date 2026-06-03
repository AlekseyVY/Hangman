package io.github.alekseyvy.hangman.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameState {
    private final HashSet<Character> wrongGuesses = new HashSet<>();
    private final String word;
    private final List<Character> publicWord =  new ArrayList<>();

    public GameState(String word) {
        this.word = word;
    }

    public List<Character> getPublicWord() {
        return this.publicWord;
    }

    public String getWord() {
        return this.word;
    }

    public int getWrongGuessesCount() {
        return this.wrongGuesses.size();
    }

    public HashSet<Character> getWrongGuesses() {
        return this.wrongGuesses;
    }
}
