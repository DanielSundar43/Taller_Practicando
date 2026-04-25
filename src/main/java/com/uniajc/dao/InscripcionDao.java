package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.InscripcionCurso;

public class InscripcionDao {

    public void guardar(InscripcionCurso i) {
        String sql = "INSERT INTO \"practica-mvc\".inscripciones (id_estudiante, id_grupo, nota_final, estado) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, i.getIdEstudiante());
            ps.setInt(2, i.getIdGrupo());
            ps.setFloat(3, i.getNotaFinal());
            ps.setString(4, i.getEstado());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<InscripcionCurso> obtenerTodos() {
        List<InscripcionCurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM \"practica-mvc\".inscripciones";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                InscripcionCurso i = new InscripcionCurso();
                i.setIdInscripcion(rs.getInt("id_inscripcion"));
                i.setIdEstudiante(rs.getInt("id_estudiante"));
                i.setIdGrupo(rs.getInt("id_grupo"));
                i.setNotaFinal(rs.getFloat("nota_final"));
                i.setEstado(rs.getString("estado"));
                lista.add(i);
            }

        } catch (SQLException e) { e.printStackTrace(); }

        return lista;
    }
}