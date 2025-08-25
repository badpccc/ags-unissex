package org.example.infra;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final Dotenv dotenv = Dotenv.load();

    public static Connection getConnection() throws SQLException {
        String host = dotenv.get("POSTGRES_HOST");
        String port = dotenv.get("POSTGRES_PORT");
        String db = dotenv.get("POSTGRES_DB");
        String user = dotenv.get("POSTGRES_USER");
        String pass = dotenv.get("POSTGRES_PASSWORD");

        String url = dotenv.get("DATABASE_URL");

        return DriverManager.getConnection(url, user, pass);
    }
}