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
        System.out.println("  1) Organic");
        System.out.println("  2) Inorganic");
        System.out.println("  3) Recyclable");
    }
}
