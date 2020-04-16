package iteso.mx;

import iteso.mx.trashLevels.TrashLevelBegginer;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TrashLevelBegginerTest {

  TrashLevelBegginer TrashLevelValue;

  @Before
  public void setUp(){
    TrashLevelValue = new TrashLevelBegginer();
  }

  @Test
  public void testTrashLevelValue(){
    TrashLevelValue.setValue("Beginner");
    assertEquals("Beginner", TrashLevelValue.getValue());
  }

}