package iteso.mx;

import iteso.mx.games.result.SingletonGameResult;
import iteso.mx.trash.Trash;



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class Game {

    /** TWENTY. */
    private static final int TWENTY = 20;
    /** TIRTHYFIVE. */
    private static final int THIRTYFIVE = 35;
    /** FIFTY. */
    private static final int FIFTY = 50;
    /** BOUND_INT constant. */
    private static final int BOUND_INT = 199;
    /** tiemLimit. */
    private int timeLimit;
    /** numObjects. */
    private int numObjects;
    /** score. */
    private int score;
    /** level. */
    private int level;
    /** levelString. */
    private String levelString;

    /** TrashFactory variable. */
    private static Trash trashFactory;

    /**
     * Trash Array.
     */
    private ArrayList<Trash> trash;
    /**
     * Results Array.
     */
    private ArrayList<String> results = new ArrayList<String>();

    /** TIME_MULTIPLIER Constant. */
    private static final int TIME_MULTIPLIER = 5;

    /**
     *
     * @param game
     */

    private ArrayList<Integer> randomNumbers = new ArrayList<>();




    /**
     *
     * @return timeLimit.
     */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     *
     * @param timeLimit1 .
     * @param multiplier .
     */
    public void setTimeLimit(final int timeLimit1, final int multiplier) {
        this.timeLimit = getNumObjects() * multiplier;
    }

    /**
     *
     * @return numObjects.
     */
    public int getNumObjects() {
        return numObjects;
    }

    /**
     *
     * @param numObjects1 .
     */
    public void setNumObjects(final int numObjects1) {
        this.numObjects = numObjects1;
    }


    /**
     *
     * @return level.
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param level1 .
     */
    public void setLevel(final int level1) {
        this.level = level1;
    }

    /**
     *
     * @param levelString1 .
     */
    public void setLevelString(final String levelString1) {
        this.levelString = levelString1;
    }

    /**
     *
     * @return levelString string.
     */
    public String getLevelString() {
        return levelString;
    }

    /**
     * Implementation of this method depends
     * on the level.
     */
    public void prepareGame() {
        boolean validOption = false;
        Scanner input = new Scanner(System.in);


        System.out.println("Starting level " + level);
        System.out.println();

        while (!validOption) {

            System.out.println("Please Select the option (letter a, b or c)"
                + " with how many objects do you want to play with: ");
            System.out.println("  a) 20");
            System.out.println("  b) 35");
            System.out.println("  c) 50");

            String option = input.nextLine();

            if (option.equals("a")) {
                setNumObjects(TWENTY);
                validOption = true;
            } else if (option.equals("b")) {
                setNumObjects(THIRTYFIVE);
                validOption = true;
            } else if (option.equals("c")) {
                setNumObjects(FIFTY);
                validOption = true;
            } else {
                System.out.println("Invalid input, try again");
            }

        }

        System.out.println();
        System.out.println("Game set to " + numObjects + " rounds");
        System.out.println();

        //Setting time for game
        setTimeLimit(numObjects, TIME_MULTIPLIER);

        System.out.println("Game clock will be set to "
            + timeLimit + " seconds");

        System.out.println();

    }

    /**
     *
     * @param trash1 .
     */
    public void startGame(final ArrayList<Trash> trash1) {

        Scanner input = new Scanner(System.in);
        System.out.println("Ready... Set... Go!");

        randomNumbers = setRandomNumbers();
        //Timer Variables
        long timeMillis = System.currentTimeMillis();
        long timeStartSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);

        long timeSpend = 0;

        SingletonGameResult gameResult =
            SingletonGameResult.getInstance("Game Result");
        for (int i = 0; i < numObjects; i++) {

            /* Print trash object and menu option */

            System.out.println(trash1.get(randomNumbers.get(i)).getName());

            System.out.println();

            //Esto puede ser strategy
            printAnswersMenu();

            //Capture user response

            String answer = input.nextLine();

            boolean isCorrect = evalAnswer(
                    answer, trash1.get(i).getValue());

            /*in results array, write in "i" position
            the name of the trash and if he got it right or wrong*/

            if (isCorrect) {
                gameResult.score++;
                gameResult.results.add("Trash object number " + i
                        + " known as "
                        + trash1.get(randomNumbers.get(i)).getName()
                        + " was correct!");
            } else {
                gameResult.results.add("Trash object number " + i
                        + " known as "
                        + trash1.get(randomNumbers.get(i)).getName()
                        + " was incorrect");
            }


            long timeMillis2 = System.currentTimeMillis();
            long timeEndSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis2);

            timeSpend = timeEndSeconds - timeStartSeconds;

            System.out.println();
            System.out.println("timeLimit "
                + timeLimit + " Time Spend " + timeSpend);
            System.out.println();

            if (timeSpend > timeLimit) {
                System.out.println("You ran out of time :( ");
                break;
            }
        }

        //gameResult.printResults();
        //printResults();
        //System.out.println(results.get(0));
    }


    /**
     * printAnswers.
     */
    public void printAnswersMenu() {
    }


    /**
     *
     * @param userAnswer .
     * @param trashValue .
     * @return false.
     */
    public boolean evalAnswer(
        final String userAnswer, final String trashValue) {
        return false;
    }

    /**
     *
     * @return ArrayList.
     */
    public ArrayList<Integer> setRandomNumbers() {
        ArrayList<Integer> aux = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        int counter = 0;

        while (counter < numObjects) {
            int randomInt = randomGenerator.nextInt(BOUND_INT);
            if (!aux.contains(randomInt)) {
                aux.add(randomInt);
                counter++;
            }
        }
        return aux;
    }
}
