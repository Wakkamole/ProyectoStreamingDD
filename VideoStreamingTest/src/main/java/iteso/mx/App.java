package iteso.mx;

import iteso.mx.games.BegginerGame;
import iteso.mx.games.Game;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Implementation for a beginner level game
        Game game = new BegginerGame();
        game.setLevel(1);
        game.prepareGame();

    }
}
