package com.uniajc.dao;

// SQL imporrts like Connection, PreparedStatement, SQLException para manejar la conexión y las operaciones con la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// importamos las clases necesarias para manejar listas de estudiantes
import java.util.ArrayList;
import java.util.List;

// Importamos la clase de conexión a la base de datos y el modelo de Estudiante
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Estudiante;

public class EstudianteDao {
   
   

    public void guardar(Estudiante estudiante) {
               
        String sql = "INSERT INTO \"practica-mvc\".estudiantes (name, lastname, email) VALUES (?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Establecer los parámetros del PreparedStatement con los datos del estudiante
            pstmt.setString(1, estudiante.getNombre());
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getEmail());

            // Ejecutar la consulta para insertar el estudiante en la base de datos
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> estudiantes = new ArrayList<>();

        String sql = "SELECT id, name, lastname, email FROM \"practica-mvc\".estudiantes";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("name"));
                estudiante.setApellido(rs.getString("lastname"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }

    
}
