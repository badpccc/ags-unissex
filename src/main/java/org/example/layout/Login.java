package org.example.layout;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.layout.Bemvindo;
import org.example.layout.Register;
import org.example.infra.DB;
import org.example.obj.User;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Login {
    private Scene scene;

    public Login(Stage stage) {
        // Componentes da tela
        Label lblUser = new Label("Usuário:");
        TextField txtUser = new TextField();

        Label lblPass = new Label("Senha:");
        PasswordField txtPass = new PasswordField();

        Button btnLogin = new Button("Entrar");
        Label lblMessage = new Label();

        Button btnRegister = new Button("Registrar");
        Label lblMessage2 = new Label();

        //Layout Horizontal
        HBox lbnt = new HBox(10, btnLogin, lblMessage, btnRegister, lblMessage2);
        lbnt.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Layout Vertical
        VBox layout = new VBox(10, lblUser, txtUser, lblPass, txtPass, lbnt);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        scene = new Scene(layout, 480, 300);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // Ação do botão
        btnLogin.setOnAction(e -> {
            User findUser = DB.getUserByUsername(txtUser.getText());
            System.out.printf("Username: %s\n", findUser.getUsername());
            System.out.printf("Password: %s\n", findUser.getPassword());
            if (txtUser.getText().equals(findUser.getUsername()) && txtPass.getText().equals(findUser.getPassword())) {
                Bemvindo bemvindo = new Bemvindo(stage);
                stage.setScene(bemvindo.getScene());
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro de Login");
                alert.setHeaderText("Usuário ou senha incorretos");
                alert.setContentText("Verifique suas credenciais e tente novamente.");
                alert.showAndWait(); // mostra o pop-up e espera o usuário fechar
            }
        });
        btnRegister.setOnAction(e -> {
            Register register = new Register(stage);
            stage.setScene(register.getScene());
        });
    }

    // Getter da cena
    public Scene getScene() {
        return scene;
    }
}
