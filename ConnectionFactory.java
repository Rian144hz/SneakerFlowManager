package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_sneakers";
    private static final String USER = "rian";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {

            throw new RuntimeException("Erro ao conectar com o MySQL: " + e.getMessage());
        }
    }
}