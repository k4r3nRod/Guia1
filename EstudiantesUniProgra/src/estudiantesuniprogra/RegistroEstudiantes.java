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
    private final String archivo = "estudiantes.txt";

    // Sobrecarga de métodos
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

    // Guardar estudiantes en archivo
    public void guardarEstudiantes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Estudiante e : estudiantes) {
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("Estudiantes guardados correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo: " + ex.getMessage());
        }
    }

    // Cargar estudiantes desde archivo
    public void cargarEstudiantes() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // Ignorar líneas vacías
                }
                String[] datos = linea.split(",");

                if (datos.length >= 4) { // aseguramos que haya suficientes campos
                    if (datos[3].equalsIgnoreCase("Becado") && datos.length == 5) {
                        try {
                            EstudianteBecado eb = new EstudianteBecado("", "", "", 0);
                            eb.setId(datos[0].trim());
                            eb.setNombre(datos[1].trim());
                            eb.setCarrera(datos[2].trim());
                            eb.setPorcentajeBeca(Double.parseDouble(datos[4]));
                            agregarEstudiante(eb);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error en línea del archivo (becado): " + e.getMessage());
                        }
                    } else if (datos[3].equalsIgnoreCase("General")) {
                        try {
                            EstudianteGeneral eg = new EstudianteGeneral("", "", "");
                            eg.setId(datos[0].trim());
                            eg.setNombre(datos[1].trim());
                            eg.setCarrera(datos[2].trim());
                            agregarEstudiante(eg);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error en línea del archivo (general): " + e.getMessage());
                        }
                    } else {
                        System.out.println("Línea inválida en el archivo: " + linea);
                    }
                } else {
                    System.out.println("Línea inválida en el archivo: " + linea);
                }
            }
            System.out.println("Estudiantes cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Mostrar estudiantes usando getters
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("x|x No hay estudiantes registrados x|x");
            return;
        }
        for (Estudiante e : estudiantes) {
            
            System.out.print("\nID: " + e.getId() + ", Nombre: " + e.getNombre() + ", Carrera: " + e.getCarrera());
            if (e instanceof EstudianteBecado eb) {
                System.out.print(", Beca: " + eb.getPorcentajeBeca() + "%");
            }
        }
        System.out.println("\n");
    }
}
