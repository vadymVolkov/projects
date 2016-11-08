package com.volkov.main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameFinishController {

    public Label label;
    public Button newgame;

    private Form application;

    public void setApplication(Form application) {
       Main.lookForWinner();
        if (Main.getWinner()!=null) {
            label.setText(Main.getWinner().getName() + " выграл");
        } else {
            label.setText("Ничья");
        }
        this.application=application;
    }

    public void newGameAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) newgame.getScene().getWindow();
        stage.close();
        application.main();

    }
}
