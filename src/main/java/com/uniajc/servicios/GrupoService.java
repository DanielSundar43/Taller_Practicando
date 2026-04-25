package com.uniajc.servicios;


import java.util.List;
import com.uniajc.dao.GrupoDao;
import com.uniajc.modelo.Grupo;

public class GrupoService {

    private GrupoDao dao = new GrupoDao();

    public void registrar(Grupo g) {
        if (g.getIdMateria() <= 0 || g.getIdDocente() <= 0) {
            throw new IllegalArgumentException("Debe asignar materia y docente");
        }
        dao.guardar(g);
    }

    public List<Grupo> listar() {
        return dao.obtenerTodos();
    }
}