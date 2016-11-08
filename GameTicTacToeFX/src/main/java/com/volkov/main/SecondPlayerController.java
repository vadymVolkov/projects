package com.volkov.main;

import com.volkov.players.AI;
import com.volkov.players.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SecondPlayerController {

    @FXML
    private TextField login;

    @FXML
    private TextField age;

    private Form application;

    public String userName;
    public String userAge;

    private static Player playerSecond;

    public void setApplication(Form application) {
        this.application = application;
    }

    public void okAction(ActionEvent actionEvent) throws IOException {
        char secondPlayerSign = 'O';
        userName = login.getText();
        userAge = age.getText();
        int userAgeInt = Integer.parseInt(userAge);
        playerSecond = new AI(userName, userAgeInt, secondPlayerSign,0,0, "AI");
        application.secondPlayerLogin();
        application.main();

    }

    public void cancelAction(ActionEvent actionEvent) {
        login.setText("");
        age.setText("");
    }

    public static Player getPlayerSecond() {
        return playerSecond;
    }
}
