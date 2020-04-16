package iteso.mx;

import iteso.mx.games.*;
import iteso.mx.trashLevels.TrashLevelBegginer;
import iteso.mx.trash.Trash;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BegginerGameTest {

  BegginerGame Game;
  TrashLevelBegginer mockedTrashLevel;
  Trash trash;

  @Before
  public void setUp() {
    Game = new BegginerGame();
    mockedTrashLevel = new TrashLevelBegginer();
  }

  @Test
  public void testEvalAnswerACorrect(){
    mockedTrashLevel.setValue("Organic");
    assertTrue(Game.evalAnswer("a", mockedTrashLevel.getValue()));    
  }

  @Test
  public void testEvalAnswerAincorrect(){
    mockedTrashLevel.setValue("Organic");
    assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));    
  }

  @Test
  public void testEvalAnswerBCorrect(){
    mockedTrashLevel.setValue("Inorganic");
    assertTrue(Game.evalAnswer("b", mockedTrashLevel.getValue()));    
  }

  @Test
  public void testEvalAnswerBincorrect(){
    mockedTrashLevel.setValue("Inorganic");
    assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));    
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
    Game.setTimeLimit(numObjects);
    assertEquals(num*7, Game.getTimeLimit());
  }

  @Test
  public void testLevel(){
    assertEquals(1, Game.getLevel());
  }

}