package iteso.mx.games;

import iteso.mx.trash.Trash;
import iteso.mx.trashLevels.TrashLevel;
import iteso.mx.trashLevels.TrashLevelBegginer;

import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

public class BegginerGame extends Game {

    public BegginerGame(){
        level = 1;
        levelString = "Beginner";
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
