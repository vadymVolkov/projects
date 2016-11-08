package com.volkov.main;


import com.volkov.model.Board;
import com.volkov.model.Winner;
import com.volkov.players.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Main {
    public static final String AI = "AI";
    private static Player playerFirst;
    private static Player playerSecond;
    private static Player currentPlayer;
    private static Player winner;
    private static Board board;
    private static Winner lookForWinner;
    private static int playerFirstWins;
    private static int playerSecondWins;


    static void creatPlayer() {
        char firstPlayerSign = 'X';
        char secondPlayerSign = 'O';


        playerFirst = FirstPlayerController.getPlayerFirst();
        playerSecond = SecondPlayerController.getPlayerSecond();
        currentPlayer = playerFirst;
    }

    public static void blockTheButtons(ArrayList<Button> buttons) {
        for (int k = 0; k < buttons.size(); k++) {
            Button button;
            button = buttons.get(k);
            if (button.getText() == "") {
                button.setText(" ");
            }
        }
    }

    public static void addWinsToPlayer(Player player) {
        int wins = player.getWins();
        player.setWins(wins + 1);
    }
    public static void addLoseToOponent(Player player) {
        Player looser = getOponent(player);
        int lose = looser.getLose();
        looser.setLose(lose + 1);
    }
    public static Player getOponent(Player player) {
        if (player.getName()==playerFirst.getName()) {
            return playerSecond;
        } else {
            return playerFirst;
        }
    }

    public static Button findButtonByID(String id, ArrayList<Button> buttons) {
        for (int k = 0; k < buttons.size(); k++) {
            Button button;
            button = buttons.get(k);
            if (button.getId().equals(id)) {
                return button;
            }
        }
        return null;
    }

    static void creatBoard() {
        board = new Board(playerFirst, playerSecond);
    }

    public static void lookForWinner() {
        lookForWinner = new Winner();
        lookForWinner.search(board.getBoard(), playerFirst, playerSecond);
        winner = lookForWinner.getWinner();
    }

    public static void changePlayer() {
        if (currentPlayer == playerFirst) {
            currentPlayer = playerSecond;
        } else {
            currentPlayer = playerFirst;
        }
    }

    static boolean gameFinish() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoard()[i][j] != 'X' && board.getBoard()[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }


    public static Player getPlayerFirst() {
        return playerFirst;
    }

    public static Player getPlayerSecond() {
        return playerSecond;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    public static Player getNextPlayer() {
        if (getCurrentPlayer().getName().equals(getPlayerFirst().getName())) {
            return getPlayerSecond();
        } else {
            return getPlayerFirst();
        }
    }

    public static Board getBoardClass() {
        return board;
    }

    public static Player getWinner() {
        return winner;
    }


    public static String lookWinPos(char[][] fieldTemp) {

        char currentPlayerType = getCurrentPlayer().getType();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[][] duplicateField = makeDuplicateField(fieldTemp);
                if (duplicateField[i][j] == ' ') {
                    duplicateField[i][j] = currentPlayerType;
                    if (lookForWinnerInOtherField(duplicateField)) {
                        return i + "" + j;
                    }
                }
            }
        }
        return "no";
    }
    public static String lookLosePos(char[][] fieldTemp) {

        char currentPlayerType = getNextPlayer().getType();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[][] duplicateField = makeDuplicateField(fieldTemp);
                if (duplicateField[i][j] == ' ') {
                    duplicateField[i][j] = currentPlayerType;
                    if (lookForWinnerInOtherField(duplicateField)) {
                        return i + "" + j;
                    }
                }
            }
        }
        return "no";
    }
    public static String lookNextWinPos(char[][] fieldTemp) {
        char currentPlayerType = getCurrentPlayer().getType();
        char[][] duplicateFieldTest5 = makeDuplicateField(fieldTemp);
        if (duplicateFieldTest5[1][1]==' '){
            return "11";
        }
        char[][] duplicateFieldTest1 = makeDuplicateField(fieldTemp);
        if (duplicateFieldTest1[0][0]==' '){
            return "00";
        }
        char[][] duplicateFieldTest2 = makeDuplicateField(fieldTemp);
        if (duplicateFieldTest2[0][2]==' '){
            return "02";
        }
        char[][] duplicateFieldTest3 = makeDuplicateField(fieldTemp);
        if (duplicateFieldTest3[2][0]==' '){
            return "20";
        }
        char[][] duplicateFieldTest4 = makeDuplicateField(fieldTemp);
        if (duplicateFieldTest4[2][2]==' '){
            return "22";
        }



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[][] duplicateField = makeDuplicateField(fieldTemp);
                if (duplicateField[i][j] == ' ') {
                    duplicateField[i][j] = currentPlayerType;
                    if (lookWinPos(duplicateField)!="no") {
                        return lookWinPos(duplicateField);
                    }
                }
            }
        }
        return "no";
    }

    private static char[][] makeDuplicateField(char[][] fieldForDuplicate) {
        char[][] duplicate = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                duplicate[i][j] = fieldForDuplicate[i][j];
            }
        }
        return duplicate;
    }

    private static boolean lookForWinnerInOtherField(char[][] dublicate) {
        lookForWinner = new Winner();
        lookForWinner.search(dublicate, playerFirst, playerSecond);
        winner = lookForWinner.getWinner();
        if (winner != null) {
            return true;
        } else {
            return false;
        }

    }

    public static void aiMakemove(Label label1, ArrayList<Button> buttons) {
        lookForWinner();


        if (!gameFinish() && getWinner() == null) {
            char[][] field = getBoardClass().getBoard();
            String foundId;
            String foundId2 = "no";
            String foundId3 = "no";
            foundId=lookWinPos(field);
            if (foundId=="no") {
                foundId2 = lookLosePos(field);
            }
            if (foundId2=="no" && foundId=="no") {
                foundId3 = lookNextWinPos(field);
            }


            if (foundId3 != "no" && foundId2=="no" && foundId=="no") {

                int i = foundId3.charAt(0) - 48;
                int j = foundId3.charAt(1) - 48;
                String id = i + "" + j;
                Button button = Main.findButtonByID(id, buttons);
                field[i][j] = Main.getCurrentPlayer().getType();
                button.setText(Main.getCurrentPlayer().getType() + "");
                label1.setText(getCurrentPlayer().getName() + " сделал свой ход");

                changePlayer();
                if (getCurrentPlayer().getBrain().equals(AI)) {
                    aiMakemove(label1, buttons);

                }
            }


            if (foundId2 != "no") {

                int i = foundId2.charAt(0) - 48;
                int j = foundId2.charAt(1) - 48;
                String id = i + "" + j;
                Button button = Main.findButtonByID(id, buttons);
                field[i][j] = Main.getCurrentPlayer().getType();
                button.setText(Main.getCurrentPlayer().getType() + "");
                label1.setText(getCurrentPlayer().getName() + " сделал свой ход");

                changePlayer();
                if (getCurrentPlayer().getBrain().equals(AI)) {
                    aiMakemove(label1, buttons);

                }
            }

            if (foundId != "no") {

                int i = foundId.charAt(0) - 48;
                int j = foundId.charAt(1) - 48;
                String id = i + "" + j;
                Button button = Main.findButtonByID(id, buttons);
                field[i][j] = Main.getCurrentPlayer().getType();
                button.setText(Main.getCurrentPlayer().getType() + "");
                label1.setText(getCurrentPlayer().getName() + " сделал свой ход");

                changePlayer();
                if (getCurrentPlayer().getBrain().equals(AI)) {
                    aiMakemove(label1, buttons);

                }
            }
            if (foundId == "no" && foundId2 == "no" && foundId3=="no") {


                Random rnd = new Random();
                int i = rnd.nextInt(3);
                int j = rnd.nextInt(3);
                while (field[i][j] != ' ') {
                    i = rnd.nextInt(3);
                    j = rnd.nextInt(3);
                }
                String id = i + "" + j;
                Button button = Main.findButtonByID(id, buttons);
                field[i][j] = Main.getCurrentPlayer().getType();
                button.setText(Main.getCurrentPlayer().getType() + "");
                label1.setText(getCurrentPlayer().getName() + " сделал свой ход");

                changePlayer();
                if (getCurrentPlayer().getBrain().equals(AI)) {
                    aiMakemove(label1, buttons);

                }
            }
        } else {
            label1.setText(getWinner().getName() + " Выграл " + getWinner().getType());
            changePlayer();
        }
    }

    public static void playerMakemove(String id, Label label1, ArrayList<Button> buttons) {

        Button button = Main.findButtonByID(id, buttons);

        if (button.getText() == "") {
            button.setText(Main.getCurrentPlayer().getType() + "");

            String move = button.getId();
            int i = move.charAt(0) - 48;
            int j = move.charAt(1) - 48;
            char[][] field = getBoardClass().getBoard();
            field[i][j] = getCurrentPlayer().getType();
            label1.setText(getCurrentPlayer().getName() + " сделал свой ход");
        }
        lookForWinner();
        if (getWinner() == null && !gameFinish()) {
            changePlayer();
            aiMakemove(label1, buttons);
        }
    }



    public static List<Person> getPerson() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT name, age, wins, lose from persons");
             ResultSet resultSet = ps.executeQuery()) {
            ArrayList<Person> usersAll = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int age = resultSet.getInt(2);
                int wins = resultSet.getInt(3);
                int lose = resultSet.getInt(4);
                usersAll.add(new Person(name, age, wins, lose));
            }
            return usersAll;
        }
    }

    public static void addNewPerson(Player player, int winsP, int loseP) throws SQLException, ClassNotFoundException {
        String name = player.getName();
        int age = player.getAge();
        int wins = player.getWins();
        int lose = player.getLose();
        if (checkPersons(player)) {
            wins=getWinsByName(name)+winsP;
            lose=getLoseByName(name)+loseP;
            try (Connection c = getConnection();
                 PreparedStatement ps = c.prepareStatement("UPDATE persons SET wins= ? WHERE name = ?")) {
                ps.setInt(1, wins);
                ps.setString(2,name);
                ps.executeUpdate();
            }
            try (Connection c = getConnection();
                 PreparedStatement ps = c.prepareStatement("UPDATE persons SET lose= ? WHERE name = ?")) {
                ps.setInt(1, lose);
                ps.setString(2,name);
                ps.executeUpdate();
            }
        } else {
            try (Connection c = getConnection();
                 PreparedStatement ps = c.prepareStatement("INSERT INTO persons (name, age, wins, lose) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setInt(3, wins);
                ps.setInt(4, lose);
                ps.executeUpdate();
            }
        }
    }

    public static int getWinsByName(String name) throws SQLException, ClassNotFoundException {
        int wins;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT wins FROM persons WHERE name = ?");) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            wins = resultSet.getInt(1);
        }

        return wins;
    }

    public static int getLoseByName(String name) throws SQLException, ClassNotFoundException {
        int lose;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT lose FROM persons WHERE name = ?");) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            lose = resultSet.getInt(1);
        }

        return lose;
    }

    public static boolean checkPersons(Player player) throws SQLException, ClassNotFoundException {
        String name = player.getName();
        int id=-1;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id FROM persons WHERE name = ?")) {
            ps.setString(1, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }
            }
        }
        if (id ==-1) {
            return false;
        } else {
            return true;
        }

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Main jdbcExample = new Main();
        Properties properties= jdbcExample.loadProperties();
        return (Connection) DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream("db.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
