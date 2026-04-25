package com.uniajc.controlador;

import com.uniajc.modelo.InscripcionCurso;
import com.uniajc.servicios.InscripcionCursoService;
import com.uniajc.vista.VistaInscripcion;

public class ControladorInscripcionCurso {

    private final VistaInscripcion vista;
    private final InscripcionCursoService servicio;

    public ControladorInscripcionCurso(VistaInscripcion vista, InscripcionCursoService servicio) {
        this.vista = vista;
        this.servicio = servicio;
    }

    public void registrarInscripcion() {

        try {
            InscripcionCurso inscripcion = vista.solicitar();

            if (inscripcion != null) {
                servicio.registrar(inscripcion);
                vista.mostrarMensaje("Inscripción registrada exitosamente.");
            }

        } catch (Exception e) {
            vista.mostrarMensaje("Error al registrar la inscripción.");
        }
    }

    public void mostrarTodasLasInscripciones() {
        vista.mostrar(servicio.listar());
    }
}
