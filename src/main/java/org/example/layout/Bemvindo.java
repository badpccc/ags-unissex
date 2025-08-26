package org.example.layout;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bemvindo {
    private Scene scene;

    public Bemvindo(Stage stage) {
        Label lbl = new Label("Bem-vindo ao sistema!");
        VBox layout = new VBox(10, lbl);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
