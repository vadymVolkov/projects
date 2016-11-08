package com.volkov.players;

import com.volkov.main.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;

public class AI extends Player {

    public AI(String name, int age, char type, int wins, int lose, String brain) {
        super(name, age, type, wins, lose, brain);

    }


    public String makeMove(String id, Label label1, ArrayList<Button> buttons) {



        Random rnd = new Random();
        int i = rnd.nextInt(3);
        int j = rnd.nextInt(3);
        char[][] field = Main.getBoardClass().getBoard();
        while (field[i][j] != ' ') {
            i = rnd.nextInt(3);
            j = rnd.nextInt(3);
        }
        String idN = i+""+j;
        Button button = Main.findButtonByID(idN, buttons);
        field[i][j] = Main.getCurrentPlayer().getType();
        button.setText(Main.getCurrentPlayer().getType() + "");
        return "ход сделан";


    }

}
