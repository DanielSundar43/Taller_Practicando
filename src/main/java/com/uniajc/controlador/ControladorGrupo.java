package com.uniajc.controlador;

import com.uniajc.modelo.Grupo;
import com.uniajc.servicios.GrupoService;
import com.uniajc.vista.VistaGrupo;
 
public class ControladorGrupo {
 
private final VistaGrupo vista;
    private final GrupoService servicio;
 
    public ControladorGrupo(VistaGrupo vista, GrupoService servicio) {
        this.vista = vista;
        this.servicio = servicio;
    }
 
    public void registrarGrupo() {
 
        try {
            Grupo grupo = vista.solicitar();
 
            if (grupo != null) {
                servicio.registrar(grupo);
                vista.mostrarMensaje("Grupo registrado exitosamente.");
            }
 
        } catch (Exception e) {
            vista.mostrarMensaje("Error al registrar el grupo.");
        }
    }
 
    public void mostrarTodosLosGrupos() {
        vista.mostrar(servicio.listar());
    }
}