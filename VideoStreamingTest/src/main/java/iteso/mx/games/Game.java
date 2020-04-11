package iteso.mx.games;

import iteso.mx.trash.Trash;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {

    int timeLimit;
    int numObjects;
    int score;
    int level;
    ArrayList<Trash> trash;
    String[] results;

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
            System.out.println("     a) 20");
            System.out.println("     b) 35");
            System.out.println("     c) 50");

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

    public void playGame(){
        trash = loadTrash();
        System.out.println("Ready... Set... Go!");

        for(int i = 0; i > numObjects; i++){

            //Print trash object and menu option
            //  printAnswersMenu();
            //Capture user response

            //in results array, write in "i" position the name of the trash and if he got it right or wrong
            //if answer was correct, add 1 to score
        }

        //at the end of the questions, get the total score and divide it with numObjects to get a percentage and print it
        //call "printResults" function and exit
    }

    public void printResults(String[] results) {
        System.out.println("Your score was: " + score);
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        for(int i = 0; i > results.length; i++){
            System.out.println(results[i]);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();
        System.out.println("Extiting...");
    }

   public void printAnswersMenu(){

   }

    //Implementation of this method depends on the Level
    public ArrayList<Trash> loadTrash(){
        ArrayList<Trash> trash = new ArrayList<Trash>();

        return trash;
    }


}
