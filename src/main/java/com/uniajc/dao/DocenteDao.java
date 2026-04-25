package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Docente;

public class DocenteDao {

    public void guardar(Docente d) {
        String sql = "INSERT INTO \"practica-mvc\".docentes (nombre, especialidad) VALUES (?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getNombre());
            ps.setString(2, d.getEspecialidad());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Docente> obtenerTodos() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT * FROM \"practica-mvc\".docentes";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Docente d = new Docente();
                d.setIdDocente(rs.getInt("id_docente"));
                d.setNombre(rs.getString("nombre"));
                d.setEspecialidad(rs.getString("especialidad"));
                lista.add(d);
            }

        } catch (SQLException e) { e.printStackTrace(); }

        return lista;
    }
}
