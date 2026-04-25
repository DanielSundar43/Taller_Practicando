package com.uniajc;

import java.util.Scanner;

import com.uniajc.controlador.ControladorDocente;
import com.uniajc.controlador.ControladorGrupo;
import com.uniajc.controlador.ControladorInscripcionCurso;
import com.uniajc.controlador.ControladorMateria;
import com.uniajc.servicios.DocenteService;
import com.uniajc.servicios.GrupoService;
import com.uniajc.servicios.InscripcionCursoService;
import com.uniajc.servicios.MateriaService;
import com.uniajc.vista.VistaDocente;
import com.uniajc.vista.VistaGrupo;
import com.uniajc.vista.VistaInscripcion;
import com.uniajc.vista.VistaMateria;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        ControladorMateria cm = new ControladorMateria(new VistaMateria(), new MateriaService());
        ControladorDocente cd = new ControladorDocente(new VistaDocente(), new DocenteService());
        ControladorGrupo cg = new ControladorGrupo(new VistaGrupo(), new GrupoService());
        ControladorInscripcionCurso ci = new ControladorInscripcionCurso(new VistaInscripcion(), new InscripcionCursoService());
 
        int op;
 
        do {
            System.out.println("\n1.Materia \n2.Docente \n3.Grupo \n4.Inscripcion \n0.Salir");
            op = sc.nextInt();
 
            switch (op) {
                case 1 -> { cm.registrarMateria(); cm.mostrarTodasLasMaterias(); }
                case 2 -> { cd.registrarDocente(); cd.mostrarTodosLosDocentes(); }
                case 3 -> { cg.registrarGrupo(); cg.mostrarTodosLosGrupos(); }
                case 4 -> { ci.registrarInscripcion(); ci.mostrarTodasLasInscripciones(); }
            }
 
        } while (op != 0);
    }
}