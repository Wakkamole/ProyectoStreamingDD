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
import java.util.Scanner;

public abstract class Game {

    /** TWENTY. */
    private static final int TWENTY = 20;
    /** TIRTHYFIVE. */
    private static final int THIRTYFIVE = 35;
    /** FIFTY. */
    private static final int FIFTY = 50;
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

    /**
     *
     * @param game
     */
    public void play(final Game game) {
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
        this.timeLimit = timeLimit1 * multiplier;
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
        //setTimeLimit(numObjects);

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

        //For now its 2, later is going to be numObjects
        for (int i = 0; i < numObjects; i++) {
            /* Print trash object and menu option */

            System.out.println(trash.get(i).getName());
            System.out.println();
            printAnswersMenu();

            //Capture user response

            String answer = input.nextLine();
            boolean isCorrect = evalAnswer(
                answer, trash.get(i).getValue().getValue());
            System.out.println(isCorrect);

            /*in results array, write in "i" position
            the name of the trash and if he got it right or wrong*/
            if (isCorrect) {
                score++;
                /*results[1] = "Trash object number " + 0 + " known as "
                + trash.get(0).getValue().getValue() + " was correct!";*/
                results.add("Trash object number " + i
                + " known as " + trash.get(i).getName() + " was correct!");
            } else {
                results.add("Trash object number " + i
                + " known as " + trash.get(i).getValue().getValue()
                + " was incorrect");
            }
        }

        /*at the end of the questions, get the total score
        and divide it with numObjects to get a percentage and print it
        */
        printResults(results);
        //System.out.println(results.get(0));
    }

    /**
     *
     * @param results1 .
     */
    public void printResults(final ArrayList<String> results1) {
        System.out.println("Your total score was: " + score
            + " out of " + numObjects + " possible answers");
        System.out.println();


        for (int i = 0; i < results1.size(); i++) {
            System.out.println(results1.get(i));
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
            String query = "SELECT * FROM project.trash";
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
}
