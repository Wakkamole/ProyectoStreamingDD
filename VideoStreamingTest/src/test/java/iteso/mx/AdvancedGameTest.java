package iteso.mx;
import iteso.mx.games.*;
import iteso.mx.trashLevels.TrashLevelAdvanced;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AdvancedGameTest {
    AdvancedGame Game;
    TrashLevelAdvanced mockedTrashLevel;

    @Before
    public void setUp() {
        Game = new AdvancedGame();
        mockedTrashLevel = new TrashLevelAdvanced();
    }

    @Test
    public void testEvalAnswerACorrect(){
        mockedTrashLevel.setValue("Organic");
        assertTrue(Game.evalAnswer("a", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerAIncorrect(){
        mockedTrashLevel.setValue("Organic");
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }

    @Test
    public void testEvalAnswerBCorrect(){
        mockedTrashLevel.setValue("Paper");
        assertTrue(Game.evalAnswer("b", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerBIncorrect(){
        mockedTrashLevel.setValue("Paper");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }

    @Test
    public void testEvalAnswerCCorrect(){
        mockedTrashLevel.setValue("Glass");
        assertTrue(Game.evalAnswer("c", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerCIncorrect(){
        mockedTrashLevel.setValue("Glass");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }

    @Test
    public void testEvalAnswerDCorrect(){
        mockedTrashLevel.setValue("Metal");
        assertTrue(Game.evalAnswer("d", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerDIncorrect(){
        mockedTrashLevel.setValue("Metal");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }

    @Test
    public void testEvalAnswerECorrect(){
        mockedTrashLevel.setValue("Plastic");
        assertTrue(Game.evalAnswer("e", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerEIncorrect(){
        mockedTrashLevel.setValue("Plastic");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerFCorrect(){
        mockedTrashLevel.setValue("Textile");
        assertTrue(Game.evalAnswer("f", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerFIncorrect(){
        mockedTrashLevel.setValue("Textile");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }

    @Test
    public void testEvalAnswerGCorrect(){
        mockedTrashLevel.setValue("Tech Trash");
        assertTrue(Game.evalAnswer("g", mockedTrashLevel.getValue()));
    }
    
    @Test
    public void testEvalAnswerGIncorrect(){
        mockedTrashLevel.setValue("Tech Trash");
        assertFalse(Game.evalAnswer("a", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("b", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("c", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("d", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("e", mockedTrashLevel.getValue()));
        assertFalse(Game.evalAnswer("f", mockedTrashLevel.getValue()));
    }

}