package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(mockedChoser);
    assertEquals(game.getWordToGuess(), "M_____");
  }

  @Test public void testGetRemainingAttempts() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertEquals(game.getRemainingAttempts(), Integer.valueOf(10));
  }

  @Test public void testGetsWordToGuessWithRandomWord() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);

    assertEquals(game.getWordToGuess(), "D________");
}
  @Test
  public void testGetsWordToGuessWithRandomWordTwo() {
      WordChoser mockedChoser = mock(WordChoser.class);
      when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

      Game game = new Game(mockedChoser);

      assertEquals(game.getWordToGuess(), "M_____");
  }
  @Test
  public void testGetsLetterRight() {
      WordChoser mockedChoser = mock(WordChoser.class);
      when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

      Game game = new Game(mockedChoser);

      assertEquals(game.guessLetter('K'), true);
  }

  @Test
  public void testGetsLetterWrong() {
      WordChoser mockedChoser = mock(WordChoser.class);
      when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

      Game game = new Game(mockedChoser);

      assertEquals(game.guessLetter('Z'), false);
  }

  @Test public void testGuessLetterRightAndDisplayGuessedLetter() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(mockedChoser);
    System.out.println(game.getWordToGuess());
    assertEquals(game.guessLetter('K'), true);
    assertEquals(game.getWordToGuess(), "M_K___");
  }

  @Test public void testGuessLetterWrong() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(mockedChoser);
    System.out.println(game.getWordToGuess());
    assertEquals(game.guessLetter('O'), false);
    assertEquals(game.getWordToGuess(), "M_____");
}

  @Test public void testIsGameLost() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(mockedChoser);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertEquals(game.guessLetter('F'), false);
    assertTrue("returns true if game is lost", game.isGameLost());
  }


@Test public void testIsWon() {
  WordChoser mockedChoser = mock(WordChoser.class);
  when(mockedChoser.getRandomWordFromDictionary()).thenReturn("TEA");

  Game game = new Game(mockedChoser);
  assertEquals(game.guessLetter('T'), false);
  assertEquals(game.guessLetter('E'), true);
  assertEquals(game.guessLetter('A'), true);

  assertTrue("Should return true if game is won", game.isGameWon());
}

@Test public void testIsWonWithSpecialWord() {
  WordChoser mockedChoser = mock(WordChoser.class);
  when(mockedChoser.getRandomWordFromDictionary()).thenReturn("COOL");

  Game game = new Game(mockedChoser);
  assertEquals(game.guessLetter('C'), false);
  assertEquals(game.guessLetter('O'), true);
  assertEquals(game.guessLetter('L'), true);

  assertTrue("should return true if game is won", game.isGameWon());
}

}