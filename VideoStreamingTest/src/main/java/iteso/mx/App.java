package iteso.mx;

import iteso.mx.games.AdvancedGame;
import iteso.mx.games.BegginerGame;
import iteso.mx.games.Game;
import iteso.mx.games.MediumGame;
import java.util.Scanner;

public class App {
    /**
     * Javadoc My App class.
     * @param args
     */
    public static void main(final String[] args) {
        new App().run(args);
    }
    private void run(final String[] args) {
        Boolean quit = false;
        Scanner input = new Scanner(System.in);


        while (!quit) {
            System.out.println("Welcome to the garbage classification game, "
            + "please select the level you would want to play");
            System.out.println("  a) Beginner");
            System.out.println("  b) Intermediate");
            System.out.println("  c) Advanced");

            String option = input.nextLine();

            if (option.equals("a")) {
                Game game = new BegginerGame();
                game.play(game);
            } else if (option.equals("b")) {
                Game game = new MediumGame();
                game.play(game);
            } else if (option.equals("c")) {
                Game game = new AdvancedGame();
                game.play(game);
            } else {
                System.out.println("Invalid input, try again");
            }

            System.out.println();
            System.out.println(
                "Thank you for plating! do you like to go again?");
            System.out.println("  a) Yes");
            System.out.println("  b) No");

            String flag2 = input.nextLine();

            if (flag2.equals("b")) {
                quit = true;
            }
        }

        System.out.println("We hope to see you again!");
    }
}
