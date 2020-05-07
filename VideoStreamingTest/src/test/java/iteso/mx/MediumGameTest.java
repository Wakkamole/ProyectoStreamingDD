package iteso.mx;

import iteso.mx.games.*;
import iteso.mx.trash.IntermediateTrash;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MediumGameTest {

  MediumGame Game;
  IntermediateTrash mockedIntermediateTrash;
  
  @Before
  public void setUp() {
    Game = new MediumGame();
    mockedIntermediateTrash = new IntermediateTrash();
  }

  @Test
  public void testEvalAnswerACorrect() {
    mockedIntermediateTrash.setValue("Organico");
    assertTrue(Game.evalAnswer("a",
            mockedIntermediateTrash.getValue()));    
  }

  @Test
  public void testEvalAnswerAIncorrect() {
    mockedIntermediateTrash.setValue("Organico");
    assertFalse(Game.evalAnswer("b",
            mockedIntermediateTrash.getValue()));
    assertFalse(Game.evalAnswer("c",
            mockedIntermediateTrash.getValue()));
  }

  @Test
  public void testEvalAnswerBCorrect() {
    mockedIntermediateTrash.setValue("Inorganico");
    assertTrue(Game.evalAnswer("b",
            mockedIntermediateTrash.getValue()));  
  }

  @Test
  public void testEvalAnswerBIncorrect() {
    mockedIntermediateTrash.setValue("Inorganico");
    assertFalse(Game.evalAnswer("a",
            mockedIntermediateTrash.getValue()));
    assertFalse(Game.evalAnswer("c",
            mockedIntermediateTrash.getValue()));
  }

  @Test
  public void testEvalAnswerCCorrect() {
    mockedIntermediateTrash.setValue("Reciclable");
    assertTrue(Game.evalAnswer("c",
            mockedIntermediateTrash.getValue()));    
  }

  @Test
  public void testEvalAnswerCIncorrect() {
    mockedIntermediateTrash.setValue("Reciclable");
    assertFalse(Game.evalAnswer("a",
            mockedIntermediateTrash.getValue()));
    assertFalse(Game.evalAnswer("b",
            mockedIntermediateTrash.getValue()));
  }

  @Test
  public void testNumObjects() {
    int num = 25;
    Game.setNumObjects(num);
    assertEquals(25, Game.getNumObjects());
  }

  @Test
  public void testSetTimeLimit() {
    int num = 25;
    Game.setNumObjects(num);
    int numObjects = Game.getNumObjects();
    Game.setTimeLimit(numObjects,5);
    assertTrue(Game.getTimeLimit() > 0);
  }

  @Test
  public void testGetTimeLimit() {
    int num = 25;
    Game.setNumObjects(num);
    int numObjects = Game.getNumObjects();
    Game.setTimeLimit(numObjects,5);
    assertEquals(num*5, Game.getTimeLimit());
  }

  @Test
  public void testLevel() {
    assertEquals(2, Game.getLevel());
  }

  @Test
  public void testLevelString() {
    assertEquals("Intermediate",
            Game.getLevelString());
  }

  @Test
  public void setRandomNumbersTest() {
    int num = 25;
    Game.setNumObjects(num);
    assertTrue(Game.setRandomNumbers().size() > 0);
  }

}