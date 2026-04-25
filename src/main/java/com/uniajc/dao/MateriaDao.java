package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Materia;

public class MateriaDao {

    public void guardar(Materia m) {
        String sql = "INSERT INTO \"practica-mvc\".materias (nombre_materia, creditos) VALUES (?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getNombreMateria());
            ps.setInt(2, m.getCreditos());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Materia> obtenerTodos() {
        List<Materia> lista = new ArrayList<>();
        String sql = "SELECT * FROM \"practica-mvc\".materias";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("id_materia"));
                m.setNombreMateria(rs.getString("nombre_materia"));
                m.setCreditos(rs.getInt("creditos"));
                lista.add(m);
            }

        } catch (SQLException e) { e.printStackTrace(); }

        return lista;
    }
}
