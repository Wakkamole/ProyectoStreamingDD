package iteso.mx;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import iteso.mx.games.result.SingletonGameResult;

public class SingletonGameResultTest {

  SingletonGameResult singletonTest;
  Game mockedGame;
  private static final int TEST_SCORE = 35;

  @Before
  public void setUp() {
    singletonTest = SingletonGameResult.getInstance("Test value");
    singletonTest.score = TEST_SCORE;
  }

  @Test
  public void getInstanceTest() {
    assertEquals(singletonTest, SingletonGameResult.getInstance("Test value"));

  }

  @Test
  public void resetInstance() {
    singletonTest.resetInstance(); 
    assertEquals(null, singletonTest.results);
    assertEquals(0, singletonTest.score);
    assertEquals(null, singletonTest.value);
    assertEquals(0, singletonTest.numObjects);
  }
  
}