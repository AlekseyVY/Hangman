package io.github.alekseyvy.hangman.service;

import io.github.alekseyvy.hangman.data.GameData;

public class ConsoleRender {

    public static void PrintMainMenu() {
        System.out.print("Добро пожаловать в виселицу, хотите начать игру? Да/Нет ");
    }

    public static void PrintContinueGame() {
        System.out.print("Хотите сыграть еще раз? Да/Нет ");
    }

    public static void PrintGameOver() {
        System.out.println("Вы проиграли!!!");
    }

    public static void PrintGameWon() {
        System.out.println("Вы выиграли!!!");
    }

    public static void PrintDelimiter() {
        System.out.println("|================================================|");
    }

    public static void PromptLetterGuess() {
        System.out.print("Введите букву: ");
    }

    public static void PrintGoodbyeGame() {
        System.out.println("Уже уходишь? пахнешь слабостью :)");
    }

    public static void PintWrongUserInput(String wrongInput) {
        System.out.printf("Вы ввели не валидное значение: %s\n", wrongInput);
    }

    public static void PrintGameData(String word, int wrongCount, String wrongWords) {
        System.out.printf("Слово: %s\nОшибки(%s): %s\n", word, wrongCount, wrongWords);
    }

    public static void PrintCurrentGameState(int hangmanState) {
        System.out.println(GameData.GAME_STATES[hangmanState]);
    }
}
