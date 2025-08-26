package org.example.layout;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.layout.Bemvindo;
import org.example.layout.Register;
import org.example.obj.User;
import org.example.infra.DB;
import org.example.layout.Login;

public class Register {
    private Scene scene;

    public Register(Stage stage) {

        // Componentes da tela
        Label lblUser = new Label("Usuário:");
        TextField txtUser = new TextField();

        Label lblPass = new Label("Senha:");
        PasswordField txtPass = new PasswordField();

        Label lblPass2 = new Label("Confirmar Senha:");
        PasswordField txtPass2 = new PasswordField();

        Button btnRegister = new Button("Registrar");
        Label lblMessage2 = new Label();

        //Layout Horizontal
        HBox lbnt = new HBox(10, btnRegister, lblMessage2);
        lbnt.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Layout Vertical
        VBox layout = new VBox(10, lblUser, txtUser,lblPass, txtPass, lblPass2, txtPass2, lbnt);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        scene = new Scene(layout, 480, 300);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        User adm = new User();
        btnRegister.setOnAction(e -> {
            adm.setUsername(txtUser.getText());
            adm.setPassword(txtPass.getText());
            DB.createTable();
            DB.insert(adm);
            Login login = new Login(stage);
            stage.setScene(login.getScene());
        });
    }
    // Getter da cena
    public Scene getScene() {
        return scene;
    }
}
