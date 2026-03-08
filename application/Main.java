package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main extends Application {

    private TextArea chatArea;
    private TextField inputField;
    private TextField nameField;
    private TextField ipField;
    private Button sendButton;
    private Button connectButton;

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    @Override
    public void start(Stage primaryStage) {

        //Connection Controls
        nameField = new TextField();
        nameField.setPromptText("Enter username");

        ipField = new TextField("127.0.0.1");
        ipField.setPromptText("Server IP");

        connectButton = new Button("Connect");
        connectButton.setOnAction(e -> connectToServer());

        HBox topBar = new HBox(10, new Label("Name:"), nameField,
                new Label("Server:"), ipField, connectButton);
        topBar.setPadding(new Insets(10));

        //Chat Display
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        // Input + Send
        inputField = new TextField();
        inputField.setPromptText("Type your message...");
        inputField.setDisable(true);

        sendButton = new Button("Send");
        sendButton.setDisable(true);

        // Send on button click
        sendButton.setOnAction(e -> sendMessage());

        // Send on Enter key
        inputField.setOnAction(e -> sendMessage());

        HBox bottomBar = new HBox(10, inputField, sendButton);
        bottomBar.setPadding(new Insets(10));

        // Root Layout
        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setCenter(chatArea);
        root.setBottom(bottomBar);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("JavaFX Chat Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Connect to the server
    private void connectToServer() {
        String username = nameField.getText().trim();
        String serverIP = ipField.getText().trim();

        if (username.isEmpty()) {
            showError("Username required");
            return;
        }

        try {
            socket = new Socket(serverIP, 59001);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Enable chat controls
            inputField.setDisable(false);
            sendButton.setDisable(false);
            connectButton.setDisable(true);

            // Send username to server
            writer.println(username);

            // Start background listener thread
            Thread listenerThread = new Thread(this::listenForMessages);
            listenerThread.setDaemon(true);
            listenerThread.start();

        } catch (IOException e) {
            showError("Could not connect: " + e.getMessage());
        }
    }

    // Listening for messages (Background Thread)
    private void listenForMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {

                String msgCopy = message; 

                Platform.runLater(() -> chatArea.appendText(msgCopy + "\n"));
            }
        } catch (IOException e) {
            Platform.runLater(() -> chatArea.appendText("Connection lost.\n"));
        }
    }

    // send messages
    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty()) {
            writer.println(msg);
            inputField.clear();
        }
    }
    // error
    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}