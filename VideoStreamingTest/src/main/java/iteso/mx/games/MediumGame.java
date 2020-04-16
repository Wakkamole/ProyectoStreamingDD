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
    private int timeLimit;

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
        this.timeLimit = timeLimit * TIME_MULTIPLIER;
    }

    @Override
    public void printAnswersMenu() {
        System.out.println("  a) Organico");
        System.out.println("  b) Inorganico");
        System.out.println("  c) Reciclable");
    }

    @Override
    public boolean evalAnswer(
        final String userAnswer, final String trashValue) {

        String aux = "";

        if (userAnswer.equals("a"))
            aux = "Organico";
        else if (userAnswer.equals("b"))
            aux = "Inorganico";
        else if (userAnswer.equals("c"))
            aux = "Reciclable";
        else{
            System.out.println("Please enter a valid option");
        }

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
