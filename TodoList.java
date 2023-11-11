import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class TodoList extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List App");

        StackPane stackPane = new StackPane();

        Rectangle redRectangle = new Rectangle(400, 300);
        redRectangle.setFill(Color.DARKBLUE);
        redRectangle.setArcWidth(20);
        redRectangle.setArcHeight(20);

        stackPane.setStyle("-fx-background-color: lightblue;");

        Label label = new Label("To-Do List App");
        label.setFont(new Font(50));
        label.setTextFill(Color.WHITE);

        stackPane.getChildren().add(redRectangle);
        stackPane.getChildren().add(label);

        StackPane.setAlignment(label, javafx.geometry.Pos.TOP_CENTER);

        Scene myScene = new Scene(stackPane, 800, 500);
        primaryStage.setScene(myScene);

        primaryStage.show();
    }
}

