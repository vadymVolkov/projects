import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridLayout extends Application {
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("OK");

        Button button2 = new Button("Cancel");

        Label label1 = new Label("Label1");
        TextField textField1 = new TextField();


        GridPane gridPane = new GridPane();
        gridPane.add(label1,0,0);
        gridPane.add(textField1,1,0);
        gridPane.add(button1,0,1);
        gridPane.add(button2,1,1);

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBOX Application");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
