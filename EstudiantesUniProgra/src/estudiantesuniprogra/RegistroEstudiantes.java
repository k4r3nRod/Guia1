/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiantesuniprogra;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author karen
 */
public class RegistroEstudiantes {

    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private final String archivo = "Estudiante.txt";

    public RegistroEstudiantes() {
    }

    // === Métodos para agregar estudiantes ===
    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void agregarEstudiante(String id, String nombre, String carrera) {
        EstudianteGeneral eg = new EstudianteGeneral(id, nombre, carrera);
        estudiantes.add(eg);
    }

    public void agregarEstudiante(String id, String nombre, String carrera, double porcentajeBeca) {
        EstudianteBecado eb = new EstudianteBecado(id, nombre, carrera, porcentajeBeca);
        estudiantes.add(eb);
    }

    // === Método para guardar estudiantes en archivo ===
    public void guardarEstudiantes() {
        try {
            File f = new File(archivo);
            BufferedWriter bw;

            if (!f.exists()) {
                // Crear archivo con encabezado
                bw = new BufferedWriter(new FileWriter(f));
                bw.write("ID,NOMBRE,CARRERA,PORCENTAJE_BECA");
                bw.newLine();
            } else {
                // Abrir archivo en modo append
                bw = new BufferedWriter(new FileWriter(f, true));
            }

            // Guardar cada estudiante
            for (Estudiante e : estudiantes) {
                bw.write(e.toString());
                bw.newLine();
            }

            bw.close();
            System.out.println("ENHORABUENA: Registro guardado correctamente.");
        } catch (IOException e) {
            System.out.println("OH NO: Error al guardar estudiantes: " + e.getMessage());
        }
    }

    // === Método para cargar estudiantes del archivo ===
    public void cargarEstudiantes() {
        File f = new File(archivo);
        if (!f.exists()) {
            System.out.println("OH NO: Archivo no encontrado. Se creara al guardar.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea = br.readLine(); // leer la cabecera y descartarla
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    agregarEstudiante(datos[0], datos[1], datos[2]);
                } else if (datos.length == 4) {
                    agregarEstudiante(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
                }
            }
            System.out.println("ENHORABUENA: Estudiantes cargados correctamente.");
        } catch (IOException e) {
            System.out.println("OH NO: Error al leer archivo: " + e.getMessage());
        }
    }

    // === Método para mostrar estudiantes en consola ===
    public void mostrarEstudiantes() {
        System.out.println("\n--- Listado de Estudiantes ---");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
