package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.DocenteDao;
import com.uniajc.modelo.Docente;

public class DocenteService {

    private DocenteDao dao = new DocenteDao();

    public void registrar(Docente d) {
        if (d.getNombre() == null || d.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del docente es obligatorio");
        }
        dao.guardar(d);
    }

    public List<Docente> listar() {
        return dao.obtenerTodos();
    }
}