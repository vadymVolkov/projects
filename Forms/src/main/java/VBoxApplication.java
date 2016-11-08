import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxApplication extends Application {
    public void start(Stage primaryStage) throws Exception {

        Label num1 = new Label("58");
        Label sign = new Label("+");
        Label num2 = new Label("42");
        HBox hBoxExtra = new HBox(num1,sign,num2);
        hBoxExtra.setMargin(num1, new Insets(5,5,5,5));
        hBoxExtra.setMargin(sign, new Insets(5,5,5,5));
        hBoxExtra.setMargin(num2, new Insets(5,5,5,5));


        Label label1 = new Label("Label1");
        final TextField textField1 = new TextField();
        HBox hBox1 = new HBox(label1,textField1);
        hBox1.setMargin(label1, new Insets(5,10,5,5));
        hBox1.setMargin(textField1, new Insets(5,10,5,5));

        final Label label2 = new Label("Label2");
        final TextArea textArea1 = new TextArea();
        HBox hBox2 = new HBox(label2, textArea1);
        hBox2.setMargin(label2, new Insets(5,10,5,5));
        hBox2.setMargin(textArea1, new Insets(5,10,5,5));

        Button button1 = new Button("ok");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String text = textField1.getText();
                if (text.equals("100")) {
                    textArea1.setText("Correct");
                } else {
                    textArea1.setText("Wrong");
                }
            }
        });
        Button button2 = new Button("cancel");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea1.clear();
            }
        });
        HBox hBox3 = new HBox(button1, button2);
        /*
        hBox3.setMargin(button1, new Insets(10,0,10,220));
        hBox3.setMargin(button2, new Insets(10,0,10,10));
        */
        hBox3.setAlignment(Pos.CENTER);





        VBox vBox = new VBox(hBoxExtra,hBox1,hBox2,hBox3);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBOX Application");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
