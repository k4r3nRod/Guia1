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
        if (id == null || !id.matches("\\d{10}")) {
            throw new IllegalArgumentException("El ID debe tener exactamente 10 dígitos.");
        }
        this.id = id;

        if (nombre == null || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{5,}")) {
            throw new IllegalArgumentException("El nombre debe tener al menos 5 letras y solo contener caracteres válidos.");
        }
        this.nombre = nombre;

        if (carrera == null || !carrera.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{5,}")) {
            throw new IllegalArgumentException("La carrera debe tener al menos 5 letras y solo contener caracteres válidos.");
        }
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + carrera;
    }
}
