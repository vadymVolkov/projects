package com.volkov.main;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class TableController {
    @FXML
    private TableView<Person> tableView;


    private Form application;
    public Button closeAll;



    public void setApplication(Form application) throws SQLException, ClassNotFoundException {

        ObservableList<Person> data = tableView.getItems();
        List<Person> persons  = Main.getPerson();
        for (int i = 0; i <persons.size() ; i++) {
            data.add(persons.get(i));
        }





        this.application = application;
    }
    public void close (ActionEvent event){
        Stage stage = (Stage) closeAll.getScene().getWindow();
        stage.close();

    }


   /* protected void addPerson(ActionEvent event) {
        ObservableList<Person> data = tableView.getItems();
        data.add(new Person(firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText()
        ));

        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
    }*/
}
