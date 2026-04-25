package com.uniajc.vista;

import java.util.List;
import java.util.Scanner;

import com.uniajc.modelo.Materia;

public class VistaMateria {

    private Scanner scanner;

    public VistaMateria() {
        this.scanner = new Scanner(System.in);
    }

    public Materia solicitarDatosMateria() {

        System.out.println("Ingrese el nombre de la materia:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese los créditos:");
        int creditos = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        return new Materia(0, nombre, creditos);
    }

    public void mostrarDetalleMateria(Materia materia) {
        System.out.println(
            "ID: " + materia.getIdMateria() +
            " | Nombre: " + materia.getNombreMateria() +
            " | Créditos: " + materia.getCreditos()
        );
    }

    public void mostrarTodasLasMaterias(List<Materia> materias) {
        System.out.println("\n====== LISTA DE MATERIAS ======");
        
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
        } else {
            for (Materia materia : materias) {
                mostrarDetalleMateria(materia);
            }
        }

        System.out.println("================================\n");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}