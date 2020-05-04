package iteso.mx.games;

import iteso.mx.trash.Trash;
import iteso.mx.trashLevels.TrashLevel;
import iteso.mx.trashLevels.TrashLevelAdvanced;
import iteso.mx.trashLevels.TrashLevelBegginer;
import iteso.mx.trashLevels.TrashLevelIntermediate;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
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
     * @param game .
     */
    public void play(final Game game) {

    //Driver
        game.prepareGame();
        trash = game.loadTrash();
        game.startGame();
    }

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
     * @return score.
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score1 .
     */
    public void setScore(final int score1) {
        this.score = score1;
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
     * @return levelString.
     */
    public String getLevelString() {
        return levelString;
    }

    /**
     *
     * @param levelString1 .
     */
    public void setLevelString(final String levelString1) {
        this.levelString = levelString1;
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
     * StartGame.
     */
    public void startGame() {

        Scanner input = new Scanner(System.in);
        System.out.println("Ready... Set... Go!");

        randomNumbers = setRandomNumbers();
        //Timer Variables
        long timeMillis = System.currentTimeMillis();
        long timeStartSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);

        long timeSpend = 0;

        for (int i = 0; i < numObjects; i++) {

            /* Print trash object and menu option */

            System.out.println(trash.get(randomNumbers.get(i)).getName());
            System.out.println();
            printAnswersMenu();

            //Capture user response

            String answer = input.nextLine();

            boolean isCorrect = evalAnswer(
                    answer, trash.get(i).getValue().getValue());

            /*in results array, write in "i" position
            the name of the trash and if he got it right or wrong*/
            if (isCorrect) {
                score++;
                results.add("Trash object number " + i
                        + " known as " + trash.get(i).getName()
                        + " was correct!");
            } else {
                results.add("Trash object number " + i
                        + " known as " + trash.get(i).getValue().getValue()
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


        printResults();
        //System.out.println(results.get(0));
    }

    /**
     * print results.
     */
    public void printResults() {

        System.out.println("Your total score was: "
            + score + " out of " + numObjects + " possible answers");
        System.out.println();


        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        System.out.println();
        System.out.println("Extiting...");
    }

    /**
     * printAnswers.
     */
    public void printAnswersMenu() {
    }

    /**
     * Implementation of this method depends on the Level.
     * @return Trash Array.
     */
    public ArrayList<Trash> loadTrash() {
        ArrayList<Trash> tmpTrash = new ArrayList<Trash>();

        try {
            String host = "jdbc:mysql://localhost:3306/project";
            String uName = "root";
            String uPass = "welcome1";
            Connection con = DriverManager.getConnection(
                host, uName, uPass);

            Statement stat = con.createStatement();
            String query = "SELECT * FROM project.trash2";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {

                //int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String value = rs.getString(levelString + "Value");

                Trash tmpTrashObject = new Trash();
                tmpTrashObject.setName(name);

                if (level == 1) {
                    TrashLevel trashLevelTmp = new TrashLevelBegginer();
                    trashLevelTmp.setValue(value);
                    tmpTrashObject.setValue(trashLevelTmp);
                } else if (level == 2) {
                    TrashLevel trashLevelTmp = new TrashLevelIntermediate();
                    trashLevelTmp.setValue(value);
                    tmpTrashObject.setValue(trashLevelTmp);
                } else {
                    TrashLevel trashLevelTmp = new TrashLevelAdvanced();
                    trashLevelTmp.setValue(value);
                    tmpTrashObject.setValue(trashLevelTmp);
                }


                tmpTrash.add(tmpTrashObject);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        System.out.println(
            "Succesfully loaded all the objects from the database");

        return tmpTrash;
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
