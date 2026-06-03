package io.github.alekseyvy.hangman.service;

import io.github.alekseyvy.hangman.model.GameState;
import io.github.alekseyvy.hangman.controller.GameController;
import io.github.alekseyvy.hangman.validators.UserInputValidator;

import java.util.Scanner;

public class GameLoop {
    GameState gameState;
    Scanner scanner;
    GameController gameController;

    public GameLoop(Scanner scanner) {
        this.gameController = new GameController();
        this.scanner = scanner;
        this.initializeGame();
    }

    public void initializeGame() {
        this.gameController.initializeNewGame();
        this.gameState = this.gameController.getGameState();
    }

    public void start() {
        while(!this.gameController.getGameOver() && !this.gameController.getGameWon()) {
            ConsoleRender.PrintDelimiter();
            this.nextTick(this.scanner);
        }

        this.winOrLoseFinalState();
        this.promptForContinue(this.scanner);
    }

    private void promptForContinue(Scanner input) {
        while(true) {
            ConsoleRender.PrintContinueGame();
            String nextGame = input.nextLine();
            if(UserInputValidator.ValidateYesUserInput(nextGame)) {
                this.initializeGame();
                this.start();
                break;
            } else if(UserInputValidator.ValidateNoUserInput(nextGame)) {
                ConsoleRender.PrintGoodbyeGame();
                break;
            } else {
                ConsoleRender.PintWrongUserInput(nextGame);
            }
        }
    }

    private void winOrLoseFinalState() {
        if(this.gameController.getGameOver()) {
            ConsoleRender.PrintCurrentGameState(this.gameController.getHangmanState());
            ConsoleRender.PrintGameOver();
        } else {
            ConsoleRender.PrintCurrentGameState(this.gameController.getHangmanState());
            ConsoleRender.PrintGameWon();
        }
    }

    private void nextTick(Scanner input) {
        int hangmanState = this.gameController.getHangmanState();
        ConsoleRender.PrintCurrentGameState(hangmanState);
        ConsoleRender.PrintGameData(this.gameController.getPrintablePublicWord(), this.gameState.getWrongGuessesCount(), this.gameController.getPrintableWrongWords());
        while(true){
            ConsoleRender.PromptLetterGuess();
            String letter = input.nextLine();
            if(UserInputValidator.isRussianChar(letter.charAt(0))) {
                this.gameController.updateGuess(letter);
                break;
            } else {
                ConsoleRender.PintWrongUserInput(letter);
            }
        }
    }
}
