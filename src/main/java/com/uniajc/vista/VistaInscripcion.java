package com.uniajc.vista;

import java.util.*;
import com.uniajc.modelo.InscripcionCurso;

public class VistaInscripcion {

    private Scanner sc = new Scanner(System.in);

    public InscripcionCurso solicitar() {
        System.out.println("ID Estudiante:");
        int e = sc.nextInt();

        System.out.println("ID Grupo:");
        int g = sc.nextInt();

        System.out.println("Nota:");
        float n = sc.nextFloat();
        sc.nextLine();

        System.out.println("Estado:");
        String estado = sc.nextLine();

        return new InscripcionCurso(0, e, g, n, estado);
    }

    public void mostrar(List<InscripcionCurso> lista) {
        lista.forEach(i -> System.out.println(i.getIdInscripcion() + " Nota: " + i.getNotaFinal()));
    }
}