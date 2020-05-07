package iteso.mx;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import iteso.mx.facade.GameFacade;
import iteso.mx.games.BegginerGame;

public class GameFacadeTest {

  GameFacade testGameFacade;
  Game mockedGame;

  @Before
  public void setUp() {
    testGameFacade = new GameFacade();
  }
  
}