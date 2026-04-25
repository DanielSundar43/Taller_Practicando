package com.uniajc.vista;

import java.util.*;
import com.uniajc.modelo.Docente;

public class VistaDocente {

    private Scanner sc = new Scanner(System.in);

    public Docente solicitar() {
        System.out.println("Nombre:");
        String n = sc.nextLine();

        System.out.println("Especialidad:");
        String e = sc.nextLine();

        return new Docente(0, n, e);
    }

    public void mostrar(List<Docente> lista) {
        lista.forEach(d -> System.out.println(d.getNombre()));
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}