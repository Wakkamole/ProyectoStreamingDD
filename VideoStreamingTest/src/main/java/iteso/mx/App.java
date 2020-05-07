package iteso.mx;

import iteso.mx.facade.GameFacade;

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
        GameFacade gameFacade = new GameFacade();


        while (!quit) {
            System.out.println("Welcome to the garbage classification game, "
            + "please select the level you would want to play");
            System.out.println("  a) Beginner");
            System.out.println("  b) Intermediate");
            System.out.println("  c) Advanced");

            String option = input.nextLine();

            //FACADE Implementation
            gameFacade.startGame(option);

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
