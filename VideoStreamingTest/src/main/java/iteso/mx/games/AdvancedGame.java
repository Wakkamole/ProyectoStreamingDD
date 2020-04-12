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
        System.out.println("  a) Organic");
        System.out.println("  b) Paper");
        System.out.println("  c) Glass");
        System.out.println("  d) Metal");
        System.out.println("  e) Plastic");
        System.out.println("  f) Textile");
        System.out.println("  g) Tech Trash");
    }

    @Override
    public boolean evalAnswer(String userAnswer, String trashValue) {

        String aux = "";
        if (userAnswer.equals("a"))
            aux = "Organic";
        else if (userAnswer.equals("b"))
            aux = "Paper";
        else if (userAnswer.equals("c"))
            aux = "Glass";
        else if (userAnswer.equals("d"))
            aux = "Metal";
        else if (userAnswer.equals("e"))
            aux = "Plastic";
        else if (userAnswer.equals("f"))
            aux = "Textile";
        else if (userAnswer.equals("g"))
            aux = "Tech Trash";
        else
            System.out.println("Please enter a valid option");

        boolean answer = trashValue.equals(aux);
        return answer;
    }
}
