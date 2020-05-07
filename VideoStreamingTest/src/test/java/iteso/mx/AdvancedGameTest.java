package iteso.mx;
import iteso.mx.games.*;
import iteso.mx.trash.AdvancedTrash;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class AdvancedGameTest {
    AdvancedGame Game;
    AdvancedTrash mockedAdvancedTrash;

    @Before
    public void setUp() {
        Game = new AdvancedGame();
        mockedAdvancedTrash = new AdvancedTrash();
    }

    @Test
    public void testEvalAnswerACorrect() {
        mockedAdvancedTrash.setValue("Organico");
        assertTrue(Game.evalAnswer("a", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerAIncorrect() {
        mockedAdvancedTrash.setValue("Organico");
        assertFalse(Game.evalAnswer("b", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("c", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("d", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("e", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("f", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("g", mockedAdvancedTrash.getValue()));
    }

    @Test
    public void testEvalAnswerBCorrect() {
        mockedAdvancedTrash.setValue("Papel");
        assertTrue(Game.evalAnswer("b", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerBIncorrect() {
        mockedAdvancedTrash.setValue("Papel");
        assertFalse(Game.evalAnswer("a", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("c", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("d", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("e", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("f", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("g", mockedAdvancedTrash.getValue()));
    }

    @Test
    public void testEvalAnswerCCorrect() {
        mockedAdvancedTrash.setValue("Vidrio");
        assertTrue(Game.evalAnswer("c", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerCIncorrect() {
        mockedAdvancedTrash.setValue("Vidrio");
        assertFalse(Game.evalAnswer("a", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("b", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("d", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("e", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("f", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("g", mockedAdvancedTrash.getValue()));
    }

    @Test
    public void testEvalAnswerDCorrect() {
        mockedAdvancedTrash.setValue("Metal");
        assertTrue(Game.evalAnswer("d", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerDIncorrect() {
        mockedAdvancedTrash.setValue("Metal");
        assertFalse(Game.evalAnswer("a", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("b", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("c", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("e", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("f", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("g", mockedAdvancedTrash.getValue()));
    }

    @Test
    public void testEvalAnswerECorrect() {
        mockedAdvancedTrash.setValue("Plastico");
        assertTrue(Game.evalAnswer("e", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerEIncorrect() {
        mockedAdvancedTrash.setValue("Plastico");
        assertFalse(Game.evalAnswer("a", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("b", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("c", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("d", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("f", mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("g", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerFCorrect() {
        mockedAdvancedTrash.setValue("Textil");
        assertTrue(Game.evalAnswer("f", mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerFIncorrect() {
        mockedAdvancedTrash.setValue("Textil");
        assertFalse(Game.evalAnswer("a",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("b",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("c",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("d",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("e",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("g",
                mockedAdvancedTrash.getValue()));
    }

    @Test
    public void testEvalAnswerGCorrect() {
        mockedAdvancedTrash.setValue("Basura Tecnologica");
        assertTrue(Game.evalAnswer("g",
                mockedAdvancedTrash.getValue()));
    }
    
    @Test
    public void testEvalAnswerGIncorrect() {
        mockedAdvancedTrash.setValue("Basura Tecnologica");
        assertFalse(Game.evalAnswer("a",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("b",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("c",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("d",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("e",
                mockedAdvancedTrash.getValue()));
        assertFalse(Game.evalAnswer("f",
                mockedAdvancedTrash.getValue()));
    }

    @Test
    public void testNumObjects() {
      int num = 25;
      Game.setNumObjects(num);
      assertEquals(25, Game.getNumObjects());
    }
  
    @Test
    public void testTimeLimit() {
      int num = 25;
      Game.setNumObjects(num);
      int numObjects = Game.getNumObjects();
      Game.setTimeLimit(numObjects,5);
      assertEquals(num*5, Game.getTimeLimit());
    }
  
    @Test
    public void testLevel() {
      assertEquals(3, Game.getLevel());
    }

    @Test
    public void testLevelString() {
        assertEquals("Advanced", Game.getLevelString());
    }

    @Test
    public void setRandomNumbersTest() {
        int num = 25;
        Game.setNumObjects(num);
        assertTrue(Game.setRandomNumbers().size() > 0);
    }
}