package io.github.alekseyvy.hangman.controller;

import io.github.alekseyvy.hangman.data.GameData;
import io.github.alekseyvy.hangman.model.GameState;
import io.github.alekseyvy.hangman.service.WordProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GameController {
    private GameState gameState;
    private final WordProvider wordProvider;

    public GameController() {
        this.wordProvider = new WordProvider(GameData.WORDS_LIST);
    }

    private void setPublicWord() {
        Random rand = new Random();
        List<Character> publicWord = this.gameState.getPublicWord();
        String word = this.gameState.getWord();
        for (int i = 0; i < word.length(); i++) {
            publicWord.add('_');
        }

        int first = rand.nextInt(word.length());
        int second = rand.nextInt(word.length());
        publicWord.set(first, word.charAt(first));
        publicWord.set(second, word.charAt(second));
    }

    public GameState getGameState() {
        return gameState;
    }

    public void initializeNewGame() {
        String randomWord = this.wordProvider.getRandomWord();
        this.gameState = new GameState(randomWord);
        this.setPublicWord();
    }

    public String getPrintablePublicWord() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : this.gameState.getPublicWord()) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private void updatePublicWord(char letter) {
        String word = this.gameState.getWord();
        List<Character> publicWord = this.gameState.getPublicWord();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char temp = publicWord.get(i);
            if(c == letter && temp == '_') {
                publicWord.set(i, letter);
                break;
            }
        }
    }

    public void updateGuess(String guess) {
        String word = this.gameState.getWord();
        HashSet<Character> wrongGuesses = this.gameState.getWrongGuesses();
        if(word.contains(guess)) {
            this.updatePublicWord(guess.charAt(0));
        } else {
            wrongGuesses.add(guess.charAt(0));
        }
    }

    public int getHangmanState() {
        return this.gameState.getWrongGuessesCount();
    }

    public boolean getGameWon() {
        List<Character> publicWord = this.gameState.getPublicWord();
        for(char letter: publicWord) {
            if(letter == '_') {
                return false;
            }
        }
        return true;
    }

    public boolean getGameOver() {
        return this.gameState.getWrongGuessesCount() == GameData.GUESS_LIMIT;
    }

    public String getPrintableWrongWords() {
        HashSet<Character> wrongGuesses = this.gameState.getWrongGuesses();
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter: wrongGuesses) {
            stringBuilder.append(letter).append(", ");
        }
        return stringBuilder.toString().trim();
    }
}
