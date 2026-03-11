package application;

import database.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {
        try (Connection con = ConnectionFactory.getConnection()) {
            System.out.println("Conexão com o DBeaver/MySQL funcionou perfeitamente.");
        } catch (SQLException e) {
            System.out.println("Falha na conexão.");
            e.printStackTrace();
        }
    }
}