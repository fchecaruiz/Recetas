package com.ejemplo.recetas.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.recetas.entidades.Dificultad;
import com.ejemplo.recetas.entidades.Receta;

public class RecetaDAO {

    // Cargar el driver MySQL (opcional en algunos entornos, necesario en Tomcat 11)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String jdbcURL = "jdbc:mysql://localhost:3306/recetas?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "usr_recetas";
    private String jdbcPassword = "Recetas_123";

    // Método para obtener conexión
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Obtener todas las recetas con dificultad en texto
    public List<Receta> obtenerRecetas() {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT r.id, r.nombre, r.FK_dificultad, d.dificultad " +
                     "FROM Recetas r LEFT JOIN Dificultades d ON r.FK_dificultad = d.id " +
                     "ORDER BY r.id DESC";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Receta r = new Receta();
                r.setId(rs.getInt("id"));
                r.setNombre(rs.getString("nombre"));
                r.setFkDificultad(rs.getInt("FK_dificultad"));
                r.setDificultad(rs.getString("dificultad"));
                recetas.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recetas;
    }

    // Insertar nueva receta
    public boolean insertarReceta(Receta receta) {
        String sql = "INSERT INTO Recetas (nombre, FK_dificultad) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, receta.getNombre());
            statement.setInt(2, receta.getFkDificultad());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las dificultades
    public List<Dificultad> obtenerDificultades() {
        List<Dificultad> dificultades = new ArrayList<>();
        String sql = "SELECT id, dificultad FROM Dificultades";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("dificultad");
                dificultades.add(new Dificultad(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dificultades;
    }
}