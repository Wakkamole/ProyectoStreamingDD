package iteso.mx.games;

import iteso.mx.trash.Trash;

import java.util.ArrayList;
import java.util.Scanner;

public class BegginerGame extends Game {

    //@Override PENDING
    public void loadTrash(ArrayList<Trash> trash) {
        super.loadTrash();
    }

    @Override
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit * 7;
    }

    @Override
    public void printAnswersMenu() {
        System.out.println("  1) Organica");
        System.out.println("  2) Inorganica");
    }
}
