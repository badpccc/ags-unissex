package org.example.infra;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;
import org.example.obj.User;

public class DB {

    private static final Dotenv dotenv = Dotenv.load();

    public DB() throws SQLException {
    }

    public static Connection getConnection() throws SQLException {
        String url = dotenv.get("DATABASE_URL");
        String user = dotenv.get("POSTGRES_USER");
        String pass = dotenv.get("POSTGRES_PASSWORD");
        return DriverManager.getConnection(url, user, pass);
    }

    // Método para criar a tabela 'usuarios'
    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id SERIAL PRIMARY KEY,
                usuario VARCHAR(50) NOT NULL,
                senha VARCHAR(50) NOT NULL
            )
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'usuarios' criada ou já existia!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir usuário e pegar o ID gerado
    public static void insert(User user) {
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?) RETURNING id";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int idGerado = rs.getInt("id");
                user.setId(idGerado); // atualiza o objeto com o id do banco
                System.out.println("Usuário inserido com ID: " + idGerado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static User getUserByUsername(String username) {
        String sql = "SELECT id, usuario, senha FROM usuarios WHERE usuario = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("usuario"));
                user.setPassword(rs.getString("senha"));
                return user; // retorna o usuário encontrado
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // retorna null se não encontrou
    }
}