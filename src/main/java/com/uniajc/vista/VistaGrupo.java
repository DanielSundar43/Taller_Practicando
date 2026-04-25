package com.uniajc.vista;

import java.util.*;
import com.uniajc.modelo.Grupo;

public class VistaGrupo {

    private Scanner sc = new Scanner(System.in);

    public Grupo solicitar() {
        System.out.println("ID Materia:");
        int m = sc.nextInt();

        System.out.println("ID Docente:");
        int d = sc.nextInt();
        sc.nextLine();

        System.out.println("Aula:");
        String a = sc.nextLine();

        System.out.println("Horario:");
        String h = sc.nextLine();

        return new Grupo(0, m, d, a, h);
    }

    public void mostrar(List<Grupo> lista) {
        lista.forEach(g -> System.out.println(g.getIdGrupo() + " Aula: " + g.getAula()));
    }
}
