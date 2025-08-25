/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiantesuniprogra;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author karen
 */
public class RegistroEstudiantes{
    private List<Estudiante> estudiantes = new ArrayList<>();
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
                String[] datos = linea.split(",");
                if (datos.length == 5 && datos[3].equals("Becado")) {
                    agregarEstudiante(datos[0], datos[1], datos[2], Double.parseDouble(datos[4]));
                } else if (datos.length >= 4 && datos[3].equals("General")) {
                    agregarEstudiante(datos[0], datos[1], datos[2]);
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
            System.out.print("ID: " + e.getId() + " | Nombre: " + e.getNombre() + " | Carrera: " + e.getCarrera());
            if (e instanceof EstudianteBecado eb) {
                System.out.print(" | Beca: " + eb.getPorcentajeBeca() + "%");
            }
        }
        System.out.println("\n");
    }
}