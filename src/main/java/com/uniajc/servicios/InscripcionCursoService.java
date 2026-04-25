package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.InscripcionCursoDao;
import com.uniajc.modelo.InscripcionCurso;

public class InscripcionCursoService {

    private InscripcionCursoDao dao = new InscripcionCursoDao();

    public void registrar(InscripcionCurso i) {
        if (i.getIdEstudiante() <= 0 || i.getIdGrupo() <= 0) {
            throw new IllegalArgumentException("Debe seleccionar estudiante y grupo");
        }
        dao.guardar(i);
    }

    public List<InscripcionCurso> listar() {
        return dao.obtenerTodos();
    }
}