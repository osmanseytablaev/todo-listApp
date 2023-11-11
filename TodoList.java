import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TodoList extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do App");

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 800, 500));

        primaryStage.show();
    }
}

