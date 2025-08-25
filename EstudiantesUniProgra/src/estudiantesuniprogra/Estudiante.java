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
    protected String id = "SIN ESPECIFICAR";
    protected String nombre = "SIN ESPECIFICAR";
    protected String carrera = "SIN ESPECIFICAR";

    public Estudiante() {}

    public Estudiante(String id, String nombre, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + carrera;
    }
}
