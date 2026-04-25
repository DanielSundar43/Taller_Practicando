package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;

public class MateriaService {

    private MateriaDao dao = new MateriaDao();

    public void registrar(Materia m) {
        if (m.getNombreMateria().isEmpty()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        dao.guardar(m);
    }

    public List<Materia> listar() {
        return dao.obtenerTodos();
    }
}