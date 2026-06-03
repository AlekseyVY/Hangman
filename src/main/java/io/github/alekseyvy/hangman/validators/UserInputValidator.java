package io.github.alekseyvy.hangman.validators;

public class UserInputValidator {
    public static boolean ValidateYesUserInput(String input) {
        return input.trim().equalsIgnoreCase("да");
    }
    public static boolean ValidateNoUserInput(String input) {
        return input.trim().equalsIgnoreCase("нет");
    }

    public static boolean isRussianChar(char ch) {
        return Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CYRILLIC
                && Character.isLetter(ch);
    }
}
