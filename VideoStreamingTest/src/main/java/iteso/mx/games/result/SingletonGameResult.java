package iteso.mx.games.result;

import java.util.ArrayList;

public final class SingletonGameResult {

    /** score variable. */
    public int score;
    /** numObjects variable. */
    public int numObjects;
    /** value variable. */
    public String value;
    /** results ArrayList. */
    public ArrayList<String> results = new ArrayList<String>();
    /** SingletonGameResult instance. */
    private static SingletonGameResult instance;

    /**
     *
     * @param value1 .
     */
    private SingletonGameResult(final String value1) {
        this.value = value1;
    }

    /**
     *
     * @param value .
     * @return instance.
     */
    public static SingletonGameResult getInstance(final String value) {
        if (instance == null) {
            instance = new SingletonGameResult(value);
        }

        return instance;
    }

    /** printResults method . */
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

    /** resetInstance Method . */
    public void resetInstance() {
        SingletonGameResult.instance = null;
        this.results = null;
        this.score = 0;
        this.value = null;
        this.numObjects = 0;
    }
}
