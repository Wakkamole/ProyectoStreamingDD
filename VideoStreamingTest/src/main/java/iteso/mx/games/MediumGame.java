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
        System.out.println("  a) Organic");
        System.out.println("  b) Inorganic");
        System.out.println("  c) Recyclable");
    }

    @Override
    public boolean evalAnswer(String userAnswer, String trashValue) {

        String aux = "";
        if (userAnswer.equals("a"))
            aux = "Organic";
        else if (userAnswer.equals("b"))
            aux = "Inorganic";
        else if (userAnswer.equals("c"))
            aux = "Recyclable";
        else
            System.out.println("Please enter a valid option");

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
