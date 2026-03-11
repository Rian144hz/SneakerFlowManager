package entities;

import database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SneakerDAO {

    public void save(Sneaker sneaker) {

        String sql = "INSERT INTO sneakers (model, mark, size, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, sneaker.getModel());
            stmt.setString(2, sneaker.getMark());
            stmt.setInt(3, sneaker.getSize());
            stmt.setDouble(4, sneaker.getPrice());


            stmt.execute();
            System.out.println("Persistent save: entities.Sneaker stored in MySQL.");

        } catch (SQLException e) {
            System.err.println("Error saving to database: " + e.getMessage());
        }
    }
    public void deleteByModel(String model) {
        String sql = "DELETE FROM sneakers WHERE model = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, model);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Persistent delete: entities.Sneaker removed from MySQL.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting from database: " + e.getMessage());
        }
    }




    public List<Sneaker> getAll() {
        List<Sneaker> sneakers = new ArrayList<>();
        String sql = "SELECT * FROM sneakers";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                String model = rs.getString("model");
                String mark = rs.getString("mark");
                int size = rs.getInt("size");
                double price = rs.getDouble("price");


                sneakers.add(new Sneaker(model, mark, size, price));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar dados: " + e.getMessage());
        }
        return sneakers;
    }
}