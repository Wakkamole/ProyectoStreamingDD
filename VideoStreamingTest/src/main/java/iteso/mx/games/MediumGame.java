package iteso.mx.games;

public class MediumGame extends Game {

    public MediumGame(){
        level = 2;
        levelString = "Intermediate";
    }

    @Override
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit * 5;
    }

    @Override
    public void printAnswersMenu() {
        System.out.println("  a) Organico");
        System.out.println("  b) Inorganico");
        System.out.println("  c) Reciclable");
    }

    @Override
    public boolean evalAnswer(String userAnswer, String trashValue) {

        String aux = "";
        if (userAnswer.equals("a"))
            aux = "Organico";
        else if (userAnswer.equals("b"))
            aux = "Inorganico";
        else if (userAnswer.equals("c"))
            aux = "Reciclable";
        else
            System.out.println("Please enter a valid option");

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
