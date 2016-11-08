import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirsApplication extends Application {
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello World");
        label.setFont(new Font(100));
        Scene scene = new Scene(label);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
