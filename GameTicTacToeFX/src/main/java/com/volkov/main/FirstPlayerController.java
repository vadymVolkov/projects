package com.volkov.main;


import com.volkov.players.Human;
import com.volkov.players.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FirstPlayerController {

    @FXML
    private TextField login;

    @FXML
    private TextField age;

    private Form application;

    public String userName;
    public String userAge;
    private static Player playerFirst;

    public void setApplication(Form application) {
        this.application = application;
    }

    public void okAction(ActionEvent actionEvent) throws IOException {
        char firstPlayerSign = 'X';
        userName = login.getText();
        userAge = age.getText();
        int userAgeInt = Integer.parseInt(userAge);
        playerFirst = new Human(userName, userAgeInt, firstPlayerSign,0,0,"Human");
        application.secondPlayerLogin();

    }

    public void cancelAction(ActionEvent actionEvent) {
        login.setText("");
        age.setText("");
    }

    public static Player getPlayerFirst() {
        return playerFirst;
    }
}
