package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Grupo;

public class GrupoDao {

    public void guardar(Grupo g) {
        String sql = "INSERT INTO \"practica-mvc\".grupos (id_materia, id_docente, aula, horario) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, g.getIdMateria());
            ps.setInt(2, g.getIdDocente());
            ps.setString(3, g.getAula());
            ps.setString(4, g.getHorario());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Grupo> obtenerTodos() {
        List<Grupo> lista = new ArrayList<>();
        String sql = "SELECT * FROM \"practica-mvc\".grupos";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Grupo g = new Grupo();
                g.setIdGrupo(rs.getInt("id_grupo"));
                g.setIdMateria(rs.getInt("id_materia"));
                g.setIdDocente(rs.getInt("id_docente"));
                g.setAula(rs.getString("aula"));
                g.setHorario(rs.getString("horario"));
                lista.add(g);
            }

        } catch (SQLException e) { e.printStackTrace(); }

        return lista;
    }
}