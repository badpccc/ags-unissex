package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Clique aqui");
        button.setOnAction(e -> button.setText("Clicado!"));

        Scene scene = new Scene(button, 300, 200);
        stage.setTitle("JavaFX com Gradle (Kotlin DSL)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
