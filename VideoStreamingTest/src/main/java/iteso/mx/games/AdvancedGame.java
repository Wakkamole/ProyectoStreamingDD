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
        System.out.println("  1) Organic");
        System.out.println("  2) Paper");
        System.out.println("  3) Glass");
        System.out.println("  4) Metal");
        System.out.println("  5) Plastic");
        System.out.println("  6) Textile");
        System.out.println("  7) Tech Trash");
    }
}
