import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
    public void start(Stage primaryStage) throws Exception {

        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button10 = new Button("/");
        Button button11 = new Button("*");
        Button button12 = new Button("-");
        Button button13 = new Button("+");
        Button button14 = new Button("=");
        Button button15 = new Button(",");
        TextField textField = new TextField();




        GridPane gridPane = new GridPane();
        gridPane.add(button7,0,1);
        gridPane.add(button8,1,1);
        gridPane.add(button9,2,1);
        gridPane.add(button10,3,1);
        gridPane.add(button4,0,2);
        gridPane.add(button5,1,2);
        gridPane.add(button6,2,2);
        gridPane.add(button11,3,2);
        gridPane.add(button1,0,3);
        gridPane.add(button2,1,3);
        gridPane.add(button3,2,3);
        gridPane.add(button12,3,3);
        gridPane.add(button0,0,4);
        gridPane.add(button15,1,4);
        gridPane.add(button14,2,4);
        gridPane.add(button13,3,4);

        gridPane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(textField,gridPane);
        vBox.setMargin(textField, new Insets(10));
        vBox.setMargin(gridPane, new Insets(10));
        vBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBOX Application");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
