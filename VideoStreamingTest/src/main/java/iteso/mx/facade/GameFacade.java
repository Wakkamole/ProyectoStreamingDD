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


public class GameFacade {

    private static Trash trashFactory;
    private ArrayList<Trash> trash;

    public void StartGame(String option){

        if (option.equals("a")) {
            Game game = new BegginerGame();
            playGame(game);
        } else if (option.equals("b")) {
            Game game = new MediumGame();
            playGame(game);
        } else if (option.equals("c")) {
            Game game = new AdvancedGame();
            playGame(game);
        } else {
            System.out.println("Invalid input, try again");
        }
    }

    public void playGame(Game game){
        game.prepareGame();

        if(game.getLevel() == 1){
            trashFactory = new BeginnerTrash();
        }else if (game.getLevel() == 2){
            trashFactory = new IntermediateTrash();
        }else if(game.getLevel() == 3){
            trashFactory = new AdvancedTrash();
        }

        trash = trashFactory.loadTrash();
        game.startGame(trash);

        SingletonGameResult gameResult = SingletonGameResult.getInstance("Game Result");
        gameResult.numObjects = game.getNumObjects();
        gameResult.printResults();
        gameResult.resetInstance();

    }

}
