package com.volkov.main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StatisticController {

    public Label playerFirst;
    public Label playerFirstWins;
    public Label playerSecond;
    public Label playerSecondWins;
    public Button ok;

    private Form application;

    public void setApplication(Form application) {
        String firstPlayerName = Main.getPlayerFirst().getName();
        String secondPlayerName = Main.getPlayerSecond().getName();
        int firstPlayerWins = Main.getPlayerFirst().getWins();
        int secondPlayerWins = Main.getPlayerSecond().getWins();
        playerFirst.setText(firstPlayerName);
        playerSecond.setText(secondPlayerName);
        playerFirstWins.setText(firstPlayerWins+"");
        playerSecondWins.setText(secondPlayerWins+"");
        this.application = application;
    }

    public void okAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }
}
