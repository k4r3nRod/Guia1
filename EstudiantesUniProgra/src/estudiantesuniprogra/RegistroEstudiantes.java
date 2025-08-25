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

    public void agregarEstudiante(String id, String nombre, String carrera, double porcentajeBeca){
        try {
            EstudianteBecado eb = new EstudianteBecado(id, nombre, carrera, porcentajeBeca);
            estudiantes.add(eb);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    // Guardar estudiantes en archivo
    public void guardarEstudiantes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Estudiante e : estudiantes) {
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("| ---- Registro guardado correctamente.");
        } catch (IOException e) {
            System.out.println("x| ---- Error al agregar estudiante: " + e.getMessage());
        }
    }


    
    //cargar datos desde el archivo
    public void cargarEstudiantes() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    agregarEstudiante(datos[0], datos[1], datos[2]);
                } else if (datos.length == 4) {
                    agregarEstudiante(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
                }
            }
            System.out.println("✔| ---- Estudiantes cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("x| ---- Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("x| ---- Error al leer archivo: " + e.getMessage());
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
