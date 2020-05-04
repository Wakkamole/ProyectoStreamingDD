package iteso.mx.games.result;

import java.util.ArrayList;

public final class SingletonGameResult {

    public int score;
    public int numObjects;
    public String value;
    public ArrayList<String> results = new ArrayList<String>();
    private static SingletonGameResult instance;

    private SingletonGameResult(String value){
        this.value = value;
    }

    public static SingletonGameResult getInstance(String value){
        if(instance == null){
            instance = new SingletonGameResult(value);
        }

        return instance;
    }

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

    public void resetInstance(){
        this.instance = null;
        this.results = null;
        this.score = 0;
        this.value = null;
        this.numObjects = 0;
    }
}
