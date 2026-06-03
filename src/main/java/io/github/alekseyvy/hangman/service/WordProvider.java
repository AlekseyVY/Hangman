package io.github.alekseyvy.hangman.service;

import io.github.alekseyvy.hangman.data.GameData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordProvider {
    private final List<String> words;
    public WordProvider(String filename) {
        this.words = this.readFile(filename);
    }

    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(words.size()));
    }

    private List<String> readFile(String filename) {
        List<String> words = new ArrayList<>();
        Path path = Path.of(GameData.BASE_PATH + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (
                IOException e
        ) {
            System.err.println("Error reading file: " + filename);
        }

        return words;
    }
}
