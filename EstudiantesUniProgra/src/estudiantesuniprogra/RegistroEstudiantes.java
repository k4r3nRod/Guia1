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
public class RegistroEstudiantes{

    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private final String archivo = "estudiantes.txt";

    // Constructor
    public RegistroEstudiantes() { 
    }

    // Método 1
    public void agregarEstudiante(Estudiante e){
        estudiantes.add(e);
    }

    // Método 2
    public void agregarEstudiante(String id, String nombre, String carrera){
        EstudianteGeneral eg = new EstudianteGeneral(id, nombre, carrera);
        estudiantes.add(eg); 
    }

    // Método 3
    public void agregarEstudiante(String id, String nombre, String carrera, double porcentajeBeca){
        try {
            EstudianteBecado eb = new EstudianteBecado(id, nombre, carrera, porcentajeBeca);
            estudiantes.add(eb);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    // Guardar en el archivo
    public void guardarEstudiantes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Estudiante e : estudiantes) {
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("✔| ---- Registro guardado correctamente.");
        } catch (IOException e) {
            System.out.println("x| ---- Error al agregar estudiante: " + e.getMessage());
        }
    }

    // Cargar desde el archivo
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
        } catch (FileNotFoundException e) {
            System.out.println("x| ---- Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("x| ---- Error al leer archivo: " + e.getMessage());
        }
    }

    // Mostrar estudiantes que estan en el archivo
    public void mostrarEstudiantes() {
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}