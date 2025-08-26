package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.layout.Login;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Login login = new Login(primaryStage);
        primaryStage.setScene(login.getScene());
        primaryStage.setTitle("Tela de Login");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}