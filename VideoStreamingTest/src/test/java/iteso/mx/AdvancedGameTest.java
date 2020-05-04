package iteso.mx;
import iteso.mx.games.*;


import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AdvancedGameTest {
    AdvancedGame Game;
    //TrashLevelAdvanced mockedTrashLevel;

    @Before
    public void setUp() {
        Game = new AdvancedGame();
        //mockedTrashLevel = new TrashLevelAdvanced();
    }

    @Test
    public void testEvalAnswerACorrect(){
        //mockedTrashLevel.setValue("Organico");
        //assertTrue(Game.evalAnswer("a", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerAIncorrect(){
        /*mockedTrashLevel.setValue("Organico");
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }

    @Test
    public void testEvalAnswerBCorrect(){
        /*mockedTrashLevel.setValue("Papel");
        assertTrue(Game.evalAnswer("b", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerBIncorrect(){
        /*mockedTrashLevel.setValue("Papel");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }

    @Test
    public void testEvalAnswerCCorrect(){
        /*mockedTrashLevel.setValue("Vidrio");
        assertTrue(Game.evalAnswer("c", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerCIncorrect(){
       /* mockedTrashLevel.setValue("Vidrio");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }

    @Test
    public void testEvalAnswerDCorrect(){
       /* mockedTrashLevel.setValue("Metal");
        assertTrue(Game.evalAnswer("d", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerDIncorrect(){
        /*mockedTrashLevel.setValue("Metal");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }

    @Test
    public void testEvalAnswerECorrect(){
       /* mockedTrashLevel.setValue("Plastico");
        assertTrue(Game.evalAnswer("e", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerEIncorrect(){
       /* mockedTrashLevel.setValue("Plastico");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerFCorrect(){
        /*mockedTrashLevel.setValue("Textil");
        assertTrue(Game.evalAnswer("f", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerFIncorrect(){
       /* mockedTrashLevel.setValue("Textil");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }

    @Test
    public void testEvalAnswerGCorrect(){
        /*mockedTrashLevel.setValue("Basura Tecnologica");
        assertTrue(Game.evalAnswer("g", mockedTrashLevel.getValue()));*/
    }
    
    @Test
    public void testEvalAnswerGIncorrect(){
        /*mockedTrashLevel.setValue("Basura Tecnologica");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));*/
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
      assertEquals(3, Game.getLevel());
    }

}