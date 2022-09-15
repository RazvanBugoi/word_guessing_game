package game;

import java.util.ArrayList;

public class Game {
  private String word;
  private ArrayList<Character> guessedLetters = new ArrayList<Character>();
  private Integer attempts = 10;

  // Following is the constructor
  public Game(WordChoser wChoser) {
    this.word = wChoser.getRandomWordFromDictionary();

  }
  public static void main(String[] args) {
    // Game game = new Game(new WordChoser());
    // game.guessLetter('O');
    // game.getWordToGuess();
  }

  public String getWordToGuess() {
    int length = word.length();
    StringBuilder hiddenWord = new StringBuilder(word);

    int i = 0;

    while (i < length) {
      Character currentLetter = word.charAt(i);
      if (i == 0) {
          //first letter is always shown
          hiddenWord.replace(i, i + 1, currentLetter.toString());
      } else {
          //show letter only if it was already guessed
          if (guessedLetters.indexOf(currentLetter) != -1) {
              hiddenWord.replace(i, i + 1, currentLetter.toString());
          } else {
              hiddenWord.replace(i, i + 1, "_");
          }
      }
      i++;
    }
    
    return hiddenWord.toString();
  }

  public Integer getRemainingAttempts() {
    return attempts;
  }

  public Boolean guessLetter(Character letter) {
      if (word.indexOf(letter) != -1 && letter != word.charAt(0)) {
        guessedLetters.add(letter);
        return true;
      } else {
        attempts --;
        return false;
      }
}

  public Boolean isGameWon() {
    // we start to scan the word at index 1,
    // as we want to omit the first letter 
    // (it's never guessed by the player!)
    for (int i = 1 ; i < word.length() ; i++) {
      Character letter = word.charAt(i);
      if (guessedLetters.indexOf(letter) == -1) {
          return false;
      }
  }

    return true;
  }

  public Boolean isGameLost() {
    if (this.getRemainingAttempts() == 0) {
      System.out.println("Game over! No more attempts remaining.");
      return true;
    } else {
      return false;
    }
  }
}
