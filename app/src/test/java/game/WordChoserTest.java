package game;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class WordChoserTest {
  @Test public void shouldGetRandomWordFromDictionary() {
    WordChoser wordChoser = new WordChoser();
    String[] MOCK_DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};
  
    assertTrue(Arrays.asList(MOCK_DICTIONARY).contains(wordChoser.getRandomWordFromDictionary()));
  }

}
