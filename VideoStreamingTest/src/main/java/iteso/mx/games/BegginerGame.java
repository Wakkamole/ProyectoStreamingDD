package iteso.mx.games;

public final class BegginerGame extends Game {

     /**
    *Javadoc comment.
    */
    private static final int LEVEL = 1;
    /**
    *Javadoc comment.
    */
    private static final int TIME_MULTIPLIER = 7;

    /**
     * JavaDoc Comment.
     */
    public BegginerGame() {
        level = LEVEL;
        levelString = "Beginner";
    }

    @Override
    public void setTimeLimit(final int timeLimit) {
        this.timeLimit = timeLimit * TIME_MULTIPLIER;
    }

    @Override
    public void printAnswersMenu() {
        System.out.println("  a) Organic");
        System.out.println("  b) Inorganic");
    }

    @Override
    public boolean evalAnswer(
        final String userAnswer, final String trashValue) {

        String aux = "";
        if (userAnswer.equals("a")) {
            aux = "Organic";
        } else if (userAnswer.equals("b")) {
            aux = "Inorganic";
        } else {
            System.out.println("Please enter a valid option");
        }

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
