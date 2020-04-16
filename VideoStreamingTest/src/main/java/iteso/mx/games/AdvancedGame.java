package iteso.mx.games;

public final class AdvancedGame extends Game {

    /**
    *Javadoc comment.
    */
    private static final int LEVEL = 3;
    /**
     * Level string constant.
     */
    private static final String L_STRING = "Advanced";
    /**
    *Javadoc comment.
    */
    private static final int TIME_MULTIPLIER = 3;
    private int timeLimit;

    /**
    *Javadoc comment.
    */
    public AdvancedGame() {
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
        System.out.println("  b) Papel");
        System.out.println("  c) Vidrio");
        System.out.println("  d) Metal");
        System.out.println("  e) Plastico");
        System.out.println("  f) Textil");
        System.out.println("  g) Basura Tecnologica");
    }

    @Override
    public boolean evalAnswer(
        final String userAnswer, final String trashValue) {

        String aux = "";

        if (userAnswer.equals("a"))
            aux = "Organico";
        else if (userAnswer.equals("b"))
            aux = "Papel";
        else if (userAnswer.equals("c"))
            aux = "Vidrio";
        else if (userAnswer.equals("d"))
            aux = "Metal";
        else if (userAnswer.equals("e"))
            aux = "Plastico";
        else if (userAnswer.equals("f"))
            aux = "Textil";
        else if (userAnswer.equals("g"))
            aux = "Basura Tecnologica";
        else
            System.out.println("Ingresa una opcion valida");


        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
