package iteso.mx.games;

import iteso.mx.trash.Trash;
import iteso.mx.trashLevels.TrashLevel;
import iteso.mx.trashLevels.TrashLevelAdvanced;
import iteso.mx.trashLevels.TrashLevelBegginer;
import iteso.mx.trashLevels.TrashLevelIntermediate;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {

    int timeLimit;
    int numObjects;
    int score;
    int level;
    String levelString;

    ArrayList<Trash> trash;
    ArrayList<String> results = new ArrayList<String>();

    //Driver
    public void play(Game game){
        game.prepareGame();
        trash = game.loadTrash();
        game.startGame();
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getNumObjects() {
        return numObjects;
    }

    public void setNumObjects(int numObjects) {
        this.numObjects = numObjects;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //Implementation of this method depends on the Level
    public void prepareGame () {
        boolean validOption = false;
        Scanner input = new Scanner(System.in);


        System.out.println("Starting level " + level);
        System.out.println();

        while(!validOption){

            System.out.println("Please Select the option (letter a, b or c) with how many objects do you want to play with: ");
            System.out.println("  a) 20");
            System.out.println("  b) 35");
            System.out.println("  c) 50");

            String option = input.nextLine();

            if(option.equals("a")){
                setNumObjects(20);
                validOption = true;
            }else if (option.equals("b")){
                setNumObjects(35);
                validOption = true;
            }else if (option.equals("c")){
                setNumObjects(50);
                validOption = true;
            }else{
                System.out.println("Invalid input, try again");
            }

        }

        System.out.println();
        System.out.println("Game set to " + numObjects + " rounds");
        System.out.println();

        //Setting time for game
        setTimeLimit(numObjects);

        System.out.println("Game clock will be set to " + timeLimit + " seconds");
        System.out.println();
    }

    public void startGame(){

        Scanner input = new Scanner(System.in);
        System.out.println("Ready... Set... Go!");

        //For now its 2, later is going to be numObjects
        for(int i=0; i < numObjects; i++){
            /* Print trash object and menu option */

            System.out.println(trash.get(i).getName());
            System.out.println();
            printAnswersMenu();

            //Capture user response

            String answer = input.nextLine();
            boolean isCorrect = evalAnswer(answer,trash.get(i).getValue().getValue());
            System.out.println(isCorrect);

            //in results array, write in "i" position the name of the trash and if he got it right or wrong
            if (isCorrect) {
                score++;
                //results[1] = "Trash object number " + 0 + " known as " + trash.get(0).getValue().getValue() + " was correct!";
                results.add("Trash object number " + i + " known as " + trash.get(i).getName() + " was correct!");
            }
            else{
                results.add("Trash object number " + i + " known as " + trash.get(i).getValue().getValue() + " was incorrect");
            }
        }

        //at the end of the questions, get the total score and divide it with numObjects to get a percentage and print it
        printResults(results);
        //System.out.println(results.get(0));
    }

    public void printResults(ArrayList<String> results) {
        System.out.println("Your total score was: " +score + " out of " + numObjects + " possible answers");
        System.out.println();


        for (int i = 0; i < results.size(); i++){
            System.out.println(results.get(i));
        }


        System.out.println();
        System.out.println("Extiting...");
    }

   public void printAnswersMenu(){

   }

    //Implementation of this method depends on the Level
    public ArrayList<Trash> loadTrash(){
        ArrayList<Trash> tmpTrash = new ArrayList<Trash>();

        try {
            String host = "jdbc:mysql://localhost:3306/project";
            String uName = "root";
            String uPass = "welcome1";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String query = "SELECT * FROM project.trash";
            ResultSet rs = stat.executeQuery(query);

            while ( rs.next()) {

                //int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String value = rs.getString(levelString+"Value");

                Trash tmpTrashObject = new Trash();
                tmpTrashObject.setName(name);

                if(level == 1){
                    TrashLevel trashLevelTmp = new TrashLevelBegginer();
                    trashLevelTmp.setValue(value);
                    tmpTrashObject.setValue(trashLevelTmp);
                }
                else if(level == 2){
                    TrashLevel trashLevelTmp = new TrashLevelIntermediate();
                    trashLevelTmp.setValue(value);
                    tmpTrashObject.setValue(trashLevelTmp);
                }else{
                    TrashLevel trashLevelTmp = new TrashLevelAdvanced();
                    trashLevelTmp.setValue(value);
                    tmpTrashObject.setValue(trashLevelTmp);
                }


                tmpTrash.add(tmpTrashObject);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        System.out.println("Succesfully loaded all the objects from the database");

        return tmpTrash;
    }

    public boolean evalAnswer(String userAnswer, String trashValue){
        return false;
    }
}
