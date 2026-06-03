package io.github.alekseyvy.hangman.data;

public class GameData {
    public static final String BASE_PATH = "src/main/resources/";
    public static final String WORDS_LIST = "words.txt";
    public static final int GUESS_LIMIT = 6;

    public static final String[] GAME_STATES = {
  """
      +----+
      |    |
           |
           |
           |
           |
    =======+===
  """,
      """
      +----+
      |    |
      0    |
           |
           |
           |
    =======+===
  """,
            """
      +----+
      |    |
      0    |
      |    |
           |
           |
    =======+===
  """,
            """
      +----+
      |    |
      0    |
     /|    |
           |
           |
    =======+===
  """,
            """
      +----+
      |    |
      0    |
     /|\\   |
           |
           |
    =======+===
  """,
            """
      +----+
      |    |
      0    |
     /|\\   |
     /     |
           |
    =======+===
  """,
            """
      +----+
      |    |
      0    |
     /|\\   |
     / \\   |
           |
    =======+===
  """,
    };
}
