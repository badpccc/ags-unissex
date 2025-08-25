package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.infra.DBConnection; // Importa a classe de conexão
import java.sql.Connection;

public class App extends Application {

    private Label conteudo;

    @Override
    public void start(Stage primaryStage) {
        conteudo = new Label("Seja Bem-Vindo!");

        // Botões do menu
        Button btnDashboard = new Button("Dashboard");
        Button btnClientes = new Button("Clientes");
        Button btnAgendamentos = new Button("Agendamentos");
        Button btnTestarDB = new Button("Testar Conexão DB"); // Novo botão

        // IDs e Classes para aplicar no CSS
        btnDashboard.setId("btn-dashboard");
        btnClientes.getStyleClass().add("menu-button");
        btnAgendamentos.getStyleClass().add("menu-button");
        btnTestarDB.getStyleClass().add("menu-button");

        // Ações dos botões
        btnDashboard.setOnAction(e -> conteudo.setText("📊 Você está no Dashboard."));
        btnClientes.setOnAction(e -> conteudo.setText("👥 Lista de Clientes."));
        btnAgendamentos.setOnAction(e -> conteudo.setText("📅 Gerenciar Agendamentos."));
        btnTestarDB.setOnAction(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                conteudo.setText("✅ Conexão com o Postgres estabelecida com sucesso!");
            } catch (Exception ex) {
                conteudo.setText("❌ Falha ao conectar com o banco: " + ex.getMessage());
            }
        });

        // Menu lateral
        VBox menuLateral = new VBox(10, btnDashboard, btnClientes, btnAgendamentos, btnTestarDB);

        // Cria um espaçador de 20px à esquerda
        Region spacer = new Region();
        spacer.setMinWidth(20);

        // Coloca o spacer e o menu lateral dentro de um HBox
        HBox lateralBox = new HBox(spacer, menuLateral);
        lateralBox.setAlignment(Pos.TOP_LEFT); // Alinha no topo à esquerda

        // Layout principal
        BorderPane root = new BorderPane();
        root.setLeft(lateralBox);
        root.setCenter(conteudo);

        // Cena
        Scene scene = new Scene(root, 1024, 720);

        // Incrementação do CSS
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // Janela principal
        primaryStage.setTitle("AGS Unissex");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}