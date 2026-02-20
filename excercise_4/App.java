package excercise_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Student Name:");
        Label idLabel = new Label("Student ID:");
        Label courseLabel = new Label("Course:");

        TextField nameField = new TextField();
        TextField idField = new TextField();
        TextField courseField = new TextField();

        Button registerButton = new Button("Register");

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(idLabel, 0, 1);
        grid.add(idField, 1, 1);

        grid.add(courseLabel, 0, 2);
        grid.add(courseField, 1, 2);

        grid.add(registerButton, 1, 4);

        registerButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String course = courseField.getText().trim();

            if (name.isEmpty() || id.isEmpty() || course.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, 
                        "All fields must be filled out.");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Registration Successful!\n\n" +
                        "Name: " + name + "\n" +
                        "ID: " + id + "\n" +
                        "Course: " + course);
                alert.show();
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Lehman Course Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}