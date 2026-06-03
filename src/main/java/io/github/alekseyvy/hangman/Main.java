package io.github.alekseyvy.hangman;

import io.github.alekseyvy.hangman.service.ConsoleRender;
import io.github.alekseyvy.hangman.service.GameLoop;
import io.github.alekseyvy.hangman.validators.UserInputValidator;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            ConsoleRender.PrintMainMenu();
            String input = scanner.nextLine();
            if(UserInputValidator.ValidateYesUserInput(input)) {
                GameLoop gameLoop = new GameLoop(scanner);
                gameLoop.start();
                break;
            } else if(UserInputValidator.ValidateNoUserInput(input)) {
                ConsoleRender.PrintGoodbyeGame();
                break;
            } else {
                ConsoleRender.PintWrongUserInput(input);
            }
        }
    }
}
