import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        final int[] counter = new int[1];


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Button button = new Button();
                button.setPrefSize(100, 100);
                button.setId(i + "" + j);
                button.setOnAction(new EventHandler<ActionEvent>() {


                    public void handle(ActionEvent event) {
                        if (button.getText() == "" && counter[0] == 1) {
                            button.setText("X");
                            counter[0]--;
                        }
                        if (button.getText() == "" && counter[0] == 0){
                            button.setText("O");
                            counter[0]++;
                        }
                    }
                });
                gridPane.add(button, i, j);
            }
        }

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBOX Application");
        primaryStage.show();
    }


}
