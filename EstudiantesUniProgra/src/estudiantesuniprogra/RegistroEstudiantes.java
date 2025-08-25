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

                if (datos.length >= 4) {
                    if (datos[3].equalsIgnoreCase("Becado")) {
                        EstudianteBecado eb = new EstudianteBecado("", "", "", 0);
                        eb.setId(datos[0]);
                        eb.setNombre(datos[1]);
                        eb.setCarrera(datos[2]);
                        eb.setPorcentajeBeca(Double.parseDouble(datos[4]));
                        agregarEstudiante(eb);
                    } else if (datos[3].equalsIgnoreCase("General")) {
                        EstudianteGeneral eg = new EstudianteGeneral("", "", "");
                        eg.setId(datos[0]);
                        eg.setNombre(datos[1]);
                        eg.setCarrera(datos[2]);
                        agregarEstudiante(eg);
                    }
                } else {
                    System.out.println("Linea invalida en el archivo: " + linea);
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
            System.out.print("ID: " + e.getId() + ", Nombre: " + e.getNombre() + ", Carrera: " + e.getCarrera());
            if (e instanceof EstudianteBecado eb) {
                System.out.print(", Beca: " + eb.getPorcentajeBeca() + "%");
            }
        }
        System.out.println("\n");
    }
}
