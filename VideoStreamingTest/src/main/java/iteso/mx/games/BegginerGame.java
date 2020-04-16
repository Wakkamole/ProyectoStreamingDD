package iteso.mx.games;

public final class BegginerGame extends Game {

     /**
    *Javadoc comment.
    */
    private static final int LEVEL = 1;
    /**
     * Level string constant.
     */
    private static final String L_STRING = "Beginner";
    /**
    *Javadoc comment.
    */
    private static final int TIME_MULTIPLIER = 7;

    /**
     * JavaDoc Comment.
     */
    public BegginerGame() {
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
        System.out.println("  a) Organico");
        System.out.println("  b) Inorganico");
    }

    @Override
    public boolean evalAnswer(
        final String userAnswer, final String trashValue) {

        String aux = "";

        if (userAnswer.equals("a"))
            aux = "Organico";
        else if (userAnswer.equals("b"))
            aux = "Inorganico";
        else

            System.out.println("Please enter a valid option");
        }

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
