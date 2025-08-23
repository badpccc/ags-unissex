package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button meuBotao; // Referência do FXML

    @FXML
    private void clicarBotao() {
        System.out.println("Botão clicado!");
        meuBotao.setText("Você clicou!"); // muda o texto do botão
    }
}
