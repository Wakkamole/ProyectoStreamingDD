package iteso.mx;

import iteso.mx.games.*;
//import iteso.mx.trashLevels.TrashLevelIntermediate;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MediumGameTest {

  MediumGame Game;
  //TrashLevelIntermediate mockedTrashLevel;
  
  @Before
  public void setUp() {
 /*   Game = new MediumGame();
    mockedTrashLevel = new TrashLevelIntermediate();*/
  }

  @Test
  public void testEvalAnswerACorrect(){
   /* mockedTrashLevel.setValue("Organico");
    assertTrue(Game.evalAnswer("a", mockedTrashLevel.getValue()));    */
  }

  @Test
  public void testEvalAnswerAincorrect(){
    /*mockedTrashLevel.setValue("Organico");
    assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
    assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));*/
  }

  @Test
  public void testEvalAnswerBCorrect(){
   /* mockedTrashLevel.setValue("Inorganico");
    assertTrue(Game.evalAnswer("b", mockedTrashLevel.getValue()));  */
  }

  @Test
  public void testEvalAnswerBincorrect(){
    /*mockedTrashLevel.setValue("Inorganico");
    assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
    assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));*/
  }

  @Test
  public void testEvalAnswerCCorrect(){
    /*mockedTrashLevel.setValue("Reciclable");
    assertTrue(Game.evalAnswer("c", mockedTrashLevel.getValue()));    */
  }

  @Test
  public void testEvalAnswerCincorrect(){
   /* mockedTrashLevel.setValue("Reciclable");
    assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
    assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));*/
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
    assertEquals(2, Game.getLevel());
  }

}