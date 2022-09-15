package game;

import java.util.ArrayList;
import java.util.Arrays;

public class WordChoser {
  private static final ArrayList<String> DICTIONARY = new ArrayList<>(Arrays.asList("MAKERS", "CANDIES", "DEVELOPER", "LONDON"));

  public String getRandomWordFromDictionary() {
    double random = Math.random() * 3;
    int value = (int)Math.round(random);
    
    return DICTIONARY.get(value);
  }
}
