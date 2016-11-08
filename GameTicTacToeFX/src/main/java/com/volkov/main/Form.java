package com.volkov.main;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.volkov.main.Main.getCurrentPlayer;

public class Form extends Application {

    private Stage primaryStage;
    private static ArrayList<Button> buttons;
    Label label1;
    String id = "";


    private int winsTrigger;
    private String move;

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        firstPlayerLogin();
    }

    public void firstPlayerLogin() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(this.getClass().getResource("firstPlayerLogin.fxml"));
        Parent root = loader.load();

        FirstPlayerController controller = loader.getController();
        controller.setApplication(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();

    }

    public void secondPlayerLogin() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(this.getClass().getResource("secondPlayerLogin.fxml"));
        Parent root = loader.load();

        SecondPlayerController controller = loader.getController();
        controller.setApplication(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();

    }

    public void statistic() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(this.getClass().getResource("statistic.fxml"));
        Parent root = loader.load();

        StatisticController controller = loader.getController();
        controller.setApplication(this);

        Scene secondScene = new Scene(root);
        Stage secondStage = new Stage();
        secondStage.setTitle("Статистика");
        secondStage.setScene(secondScene);
        secondStage.show();


    }

    public void table() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader =
                new FXMLLoader(this.getClass().getResource("tableview.fxml"));
        Parent root = loader.load();

        TableController controller = loader.getController();
        controller.setApplication(this);

        Scene secondScene = new Scene(root);
        Stage secondStage = new Stage();
        secondStage.setTitle("Статистика");
        secondStage.setScene(secondScene);
        secondStage.show();


    }

    public void gameFinish() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(this.getClass().getResource("gamefinish.fxml"));
        Parent root = loader.load();

        GameFinishController controller = loader.getController();
        controller.setApplication(this);

        Scene thirdScene = new Scene(root);
        Stage thirdStage = new Stage();
        thirdStage.setTitle("Игра закончена");
        thirdStage.setScene(thirdScene);
        thirdStage.show();

    }

    public void main() throws IOException {
        winsTrigger = 0;
        Main.creatBoard();
        if (Main.getPlayerFirst() == null && Main.getPlayerSecond() == null) {
            Main.creatPlayer();
        }

        GridPane gridPane = new GridPane();
        label1 = new Label();
        label1.setText("Игра началась" + "\n" + getCurrentPlayer().getName() + " делай ход (" + getCurrentPlayer().getType() + ")");
        buttons = new ArrayList<Button>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Button button = new Button();
                button.setPrefSize(100, 100);
                button.setId(i + "" + j);
                button.setOnAction(new EventHandler<ActionEvent>() {


                    public void handle(ActionEvent event) {

                        if (button.getText() == "") {
                            Main.playerMakemove(button.getId(), label1, buttons);
                        }
                        Main.lookForWinner();
                        label1.setText(Main.getCurrentPlayer().getName() + " делай ход(" + Main.getCurrentPlayer().getType() + ")");
                        if (Main.getWinner() != null) {
                            label1.setText("Игра окончена!" + "\n" + "Победитель " + Main.getWinner().getName() + "\n" + "Возраст: " + Main.getWinner().getAge() + "\n" + "Он играл за \" " + Main.getWinner().getType() + "\"");
                            if (Main.getWinner().getName() == Main.getPlayerFirst().getName() && winsTrigger == 0) {
                                Main.addWinsToPlayer(Main.getPlayerFirst());
                                Main.addLoseToOponent(Main.getPlayerFirst());
                                try {
                                    Main.addNewPerson(Main.getPlayerFirst(),1,0);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    Main.addNewPerson(Main.getPlayerSecond(),0,1);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                winsTrigger++;
                                try {
                                    gameFinish();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (Main.getWinner().getName() == Main.getPlayerSecond().getName() && winsTrigger == 0) {
                                Main.addWinsToPlayer(Main.getPlayerSecond());
                                Main.addLoseToOponent(Main.getPlayerSecond());
                                try {
                                    Main.addNewPerson(Main.getPlayerFirst(),0,1);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    Main.addNewPerson(Main.getPlayerSecond(),1,0);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                winsTrigger++;
                                try {
                                    gameFinish();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            Main.blockTheButtons(buttons);
                        }
                        if (Main.getWinner() == null && Main.gameFinish()) {
                            label1.setText("Игра окончена!" + "\n" + "Ничья");
                            Main.blockTheButtons(buttons);
                            try {
                                gameFinish();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });
                buttons.add(button);
                gridPane.add(button, i, j);
            }
        }

        Button newGame = new Button("Новая Игра");
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    main();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final Button statistic = new Button("Показать статистику");
        statistic.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    table();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        final Button newPlayerGame = new Button("Новые Игроки");
        newPlayerGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FXMLLoader loader =
                        new FXMLLoader(this.getClass().getResource("firstPlayerLogin.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                FirstPlayerController controller = loader.getController();
                controller.setApplication(Form.this);

                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Login");
                primaryStage.show();
            }
        });

        final Button exit = new Button("Выход");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });


        //gridPane.add(label1, 3, 0);
        gridPane.add(newGame, 1, 3);
        gridPane.add(statistic, 1, 4);
        gridPane.add(newPlayerGame, 1, 5);
        gridPane.add(exit, 1, 6);
        // gridPane.setRowSpan(label1, 3);
        gridPane.setColumnSpan(newGame, 3);
        gridPane.setColumnSpan(statistic, 3);
        gridPane.setColumnSpan(newPlayerGame, 3);
        gridPane.setColumnSpan(exit, 3);
        //gridPane.setMargin(label1, new Insets(0, 100, 0, 10));
        gridPane.setMargin(newGame, new Insets(10, 0, 10, 0));
        gridPane.setMargin(statistic, new Insets(5, 0, 10, 0));
        gridPane.setMargin(newPlayerGame, new Insets(5, 0, 10, 0));
        gridPane.setMargin(exit, new Insets(5, 0, 10, 0));

       /* HBox hBox1 = new HBox(gridPane, label1);
      hBox1.setMargin(label1 ,new Insets(100));
        label1.setAlignment(Pos.CENTER);
        VBox vBox1 = new VBox(hBox1, newGame);
       vBox1.setMargin(newGame, new Insets(40));
        vBox1.setAlignment(Pos.CENTER);*/


        Scene scene = new Scene(gridPane, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TicTacToe");
        primaryStage.show();

        if (Main.getCurrentPlayer().getBrain() == "AI") {

            Main.aiMakemove(label1, buttons);
        }
    }


    public static void main(String[] args) {

        launch();
    }
}
