package iteso.mx.facade;

import iteso.mx.games.AdvancedGame;
import iteso.mx.games.BegginerGame;
import iteso.mx.Game;
import iteso.mx.games.MediumGame;
import iteso.mx.games.result.SingletonGameResult;
import iteso.mx.trash.AdvancedTrash;
import iteso.mx.trash.BeginnerTrash;
import iteso.mx.trash.IntermediateTrash;
import iteso.mx.trash.Trash;

import java.util.ArrayList;

/**
 * GameFacade Class.
 */
public class GameFacade {

    /** LEVEL_1 constant. */
    private static final int LEVEL_1 = 1;
    /** LEVEL_2 constant. */
    private static final int LEVEL_2 = 2;
    /** LEVEL_3 constant. */
    private static final int LEVEL_3 = 3;

    /** trashFactory Trash object. */
    private static Trash trashFactory;
    /** Trash Array.  */
    private ArrayList<Trash> trash;
    Game game;

    /**
     *
     * @param option .
     */
    public void startGame(final String option) {

        if (option.equals("a")) {
            game = new BegginerGame();
            playGame(game);
        } else if (option.equals("b")) {
            game = new MediumGame();
            playGame(game);
        } else if (option.equals("c")) {
            game = new AdvancedGame();
            playGame(game);
        } else {
            System.out.println("Invalid input, try again");
        }

    }

    /**
     *
     * @param game .
     */
    public void playGame(final Game game) {
        game.prepareGame();

        if (game.getLevel() == LEVEL_1) {
            trashFactory = new BeginnerTrash();
        } else if (game.getLevel() == LEVEL_2) {
            trashFactory = new IntermediateTrash();
        } else if (game.getLevel() == LEVEL_3) {
            trashFactory = new AdvancedTrash();
        }

        trash = trashFactory.loadTrash();
        game.startGame(trash);

        SingletonGameResult gameResult =
            SingletonGameResult.getInstance("Game Result");
        gameResult.numObjects = game.getNumObjects();
        gameResult.printResults();
        gameResult.resetInstance();

    }

}
