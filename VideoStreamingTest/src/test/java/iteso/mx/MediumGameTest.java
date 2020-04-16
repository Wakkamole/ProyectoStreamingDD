package iteso.mx;

import iteso.mx.games.*;
import iteso.mx.trashLevels.TrashLevelIntermediate;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MediumGameTest {

  MediumGame Game;
  TrashLevelIntermediate mockedTrashLevel;
  
  @Before
  public void setUp() {
    Game = new MediumGame();
    mockedTrashLevel = new TrashLevelIntermediate();
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
    assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
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
    assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
  }

  @Test
  public void testEvalAnswerCCorrect(){
    mockedTrashLevel.setValue("Recyclable");
    assertTrue(Game.evalAnswer("c", mockedTrashLevel.getValue()));    
  }

  @Test
  public void testEvalAnswerCincorrect(){
    mockedTrashLevel.setValue("Recyclable");
    assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
    assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
  }

}