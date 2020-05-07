package iteso.mx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import iteso.mx.trash.IntermediateTrash;
import iteso.mx.trash.Trash;

public class IntermediateTrashTest {

  IntermediateTrash testTrash;

  @Before
  public void setUp() {
    testTrash = new IntermediateTrash();
  }

  @Test
  public void testName() {
    String trashName = "Trash1";
    testTrash.setName(trashName);
    assertEquals("Trash1", testTrash.getName());
  }
  
  @Test
  public void testValue() {
    String trashValue = "BeginnerValue";
    testTrash.setValue(trashValue);
    assertEquals("BeginnerValue", testTrash.getValue());
  }

  @Test
  public void testLoadTrash() {
    ArrayList<Trash> trashList = testTrash.loadTrash();
    assertTrue(trashList.size() == 0);
  }

}