package iteso.mx.games;

import iteso.mx.trash.Trash;

import java.util.ArrayList;

public abstract class Game {

    int timeLimit;
    int numObjects;
    int score;
    int level;
    ArrayList<Trash> objects;
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

    private void playGame(){
        System.out.println("Playing level " + level);

    }

    public  void printResults(String[] results){

    }


}
