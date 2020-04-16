package iteso.mx.games;

public final class MediumGame extends Game {
    /**
    *Javadoc comment.
    */
    private static final int LEVEL = 2;
    /**
     * Level string constant.
     */
    private static final String L_STRING = "Intermediate";
    /**
    *Javadoc comment.
    */
    private static final int TIME_MULTIPLIER = 5;

    /**
    *Javadoc comment.
    */
    public MediumGame() {
        super.setLevel(LEVEL);
        super.setLevelString(L_STRING);
    }

    /**
     *
     * @param timeLimit .
     */
    public void setTimeLimit(final int timeLimit) {
        super.setTimeLimit(timeLimit, TIME_MULTIPLIER);
    }

    @Override
    public void printAnswersMenu() {
        System.out.println("  a) Organic");
        System.out.println("  b) Inorganic");
        System.out.println("  c) Recyclable");
    }

    @Override
    public boolean evalAnswer(
        final String userAnswer, final String trashValue) {

        String aux = "";
        if (userAnswer.equals("a")) {
            aux = "Organic";
        } else if (userAnswer.equals("b")) {
            aux = "Inorganic";
        } else if (userAnswer.equals("c")) {
            aux = "Recyclable";
        } else {
            System.out.println("Please enter a valid option");
        }

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
