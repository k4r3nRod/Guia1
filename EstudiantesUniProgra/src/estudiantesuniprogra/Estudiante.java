/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiantesuniprogra;

/**
 *
 * @author karen
 */
public class Estudiante {
    protected String id="SIN ESPECIFICAR";
    protected String nombre="SIN ESPECIFICAR";
    protected String carrera="SIN ESPECIFICAR";

    public Estudiante() {
    }
    
    public Estudiante(String id, String nombre, String carrera) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }else{
            this.id = id;
        }
        
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }else{
            this.nombre = nombre;
        }
        
        if (carrera == null || carrera.isBlank()) {
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        }else{
            this.carrera = carrera;
        }   
        
    }

    public String toString() {
        return id + "," + nombre + "," + carrera;
    }
}
