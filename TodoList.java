import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.*;

public class TodoList extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List App");

        Pane stackPane = new Pane();
        Rectangle redRectangle = new Rectangle(400, 300);
        redRectangle.setFill(Color.DARKBLUE);
        redRectangle.setArcWidth(20);
        redRectangle.setArcHeight(20);

        stackPane.setStyle("-fx-background-color: lightblue;");

        Label label = new Label("To-Do List App");
        Label response = new Label(" ");
        Button btnGetText = new Button("Add Task");
        label.setFont(new Font(50));
        label.setTextFill(Color.WHITE);
        TextField textField = new TextField();
        textField.setPromptText("Enter task");
        textField.setPrefColumnCount(10);
        textField.setMaxWidth(250);
        textField.setStyle("-fx-font-size: 12px;");
        label.setLayoutX(250);
        label.setLayoutY(150);
        textField.setLayoutX(330);
        textField.setLayoutY(250);
        btnGetText.setLayoutX(360);
        btnGetText.setLayoutY(280);
        redRectangle.setLayoutX(200);
        redRectangle.setLayoutY(100);

        stackPane.getChildren().addAll(redRectangle, label, textField, btnGetText);

        Scene myScene = new Scene(stackPane, 800, 500);
        primaryStage.setScene(myScene);

        primaryStage.show();
    }
}

