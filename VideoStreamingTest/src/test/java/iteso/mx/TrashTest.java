package iteso.mx;
import iteso.mx.trash.*;
import iteso.mx.trashLevels.*;
import iteso.mx.trashLevels.TrashLevelBegginer;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrashTest {

  Trash testTrash;
  TrashLevel mockedTrashLevel;

  @Before
  public void setUp(){
    testTrash = new Trash();
    mockedTrashLevel = mock(TrashLevel.class);
    testTrash.setValue(mockedTrashLevel);
  }

  @Test
  public void testName(){
    testTrash.setName("trashName");
    assertEquals("trashName", testTrash.getName());
  }

  @Test
  public void testValue(){
    testTrash.setValue(mockedTrashLevel);
    assertEquals(mockedTrashLevel, testTrash.getValue());
  }
}