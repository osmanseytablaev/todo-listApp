import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends Application {
    private List<TaskEntry> taskEntries = new ArrayList<>();
    private Rectangle redRectangle;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List App");

        Pane stackPane = new Pane();
        redRectangle = new Rectangle(400, 300);
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
        btnGetText.setOnAction(event -> {
            // Create a new label with the text from the text field
            Label taskLabel = new Label(textField.getText());

            // Create a delete button
            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(deleteEvent -> {
                // Remove the label and delete button when the delete button is clicked
                stackPane.getChildren().removeAll(taskLabel, deleteButton);

                // Also remove the task entry from the list
                taskEntries.removeIf(entry -> entry.getLabel() == taskLabel);

                // Adjust the height of the rectangle
                adjustRectangleHeight();
            });

            // Add the new task entry to the list
            TaskEntry taskEntry = new TaskEntry(taskLabel, deleteButton);
            taskEntries.add(taskEntry);

            // Position the label and delete button within the rectangle
            double labelX = redRectangle.getLayoutX() + 10;
            double labelY = redRectangle.getLayoutY() + redRectangle.getHeight() + 10 + taskEntries.size() * 40;
            double buttonX = labelX + taskLabel.getWidth() + 10;

            taskLabel.setLayoutX(labelX);
            taskLabel.setLayoutY(labelY);
            deleteButton.setLayoutX(buttonX);
            deleteButton.setLayoutY(labelY);

            // Adjust the height of the rectangle
            adjustRectangleHeight();

            // Add the label and delete button to the stackPane
            stackPane.getChildren().addAll(taskLabel, deleteButton);
        });
    }

    private void adjustRectangleHeight() {
        // Adjust the height of the rectangle based on the number of tasks
        double newHeight = redRectangle.getHeight() + taskEntries.size() * 40;
        redRectangle.setHeight(newHeight);
    }

    private static class TaskEntry {
        private Label label;
        private Button deleteButton;

        public TaskEntry(Label label, Button deleteButton) {
            this.label = label;
            this.deleteButton = deleteButton;
        }

        public Label getLabel() {
            return label;
        }

        public Button getDeleteButton() {
            return deleteButton;
        }
    }
}

