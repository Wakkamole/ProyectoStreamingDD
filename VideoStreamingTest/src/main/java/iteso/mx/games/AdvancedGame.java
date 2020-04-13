package iteso.mx.games;

public class AdvancedGame extends Game {
    public AdvancedGame(){
        level = 3;
        levelString = "Advanced";
    }

    @Override
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit * 3;
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
    public boolean evalAnswer(String userAnswer, String trashValue) {

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
