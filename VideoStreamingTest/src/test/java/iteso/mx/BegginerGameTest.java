package iteso.mx;

import iteso.mx.games.*;
import iteso.mx.trash.BeginnerTrash;
import iteso.mx.trash.Trash;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BegginerGameTest {

  BegginerGame Game;
  BeginnerTrash mockedBeginnerTrash;
  Trash trash;

  @Before
  public void setUp() {
    Game = new BegginerGame();
    mockedBeginnerTrash = new BeginnerTrash();
  }

  @Test
  public void testEvalAnswerACorrect() {
    mockedBeginnerTrash.setValue("Organico");
    assertTrue(Game.evalAnswer("a", mockedBeginnerTrash.getValue()));
  }

  @Test
  public void testEvalAnswerAincorrect() {
    mockedBeginnerTrash.setValue("Organico");
    assertFalse(Game.evalAnswer("b", mockedBeginnerTrash.getValue()));
  }

  @Test
  public void testEvalAnswerBCorrect() {
    mockedBeginnerTrash.setValue("Inorganico");
    assertTrue(Game.evalAnswer("b", mockedBeginnerTrash.getValue()));
  }

  @Test
  public void testEvalAnswerBIncorrect() {
    mockedBeginnerTrash.setValue("Inorganico");
    assertFalse(Game.evalAnswer("a", mockedBeginnerTrash.getValue()));
  }

  @Test
  public void testNumObjects(){
    int num = 25;
    Game.setNumObjects(num);
    assertEquals(25, Game.getNumObjects());
  }

  @Test
  public void testTimeLimit(){
    int num = 25;
    Game.setNumObjects(num);
    int numObjects = Game.getNumObjects();
    Game.setTimeLimit(numObjects,5);
    assertEquals(num*5, Game.getTimeLimit());
  }

  @Test
  public void testLevel(){
    assertEquals(1, Game.getLevel());
  }

  @Test
  public void testLevelString() {
    assertEquals("Beginner", Game.getLevelString());
  }

  @Test
  public void setRandomNumbersTest() {
    int num = 25;
    Game.setNumObjects(num);
    assertTrue(Game.setRandomNumbers().size() > 0);
  }

}