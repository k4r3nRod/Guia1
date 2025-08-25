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
    private String id="SIN ESPECIFICAR";
    private String nombre="SIN ESPECIFICAR";
    private String carrera="SIN ESPECIFICAR";

    public Estudiante() {
    }
    
    public Estudiante(String id, String nombre, String carrera) {
        setId(id);
        setNombre(nombre);
        setCarrera(carrera);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || !id.matches("\\d{10}")) {
            throw new IllegalArgumentException("El ID debe tener 10 digitos, ejemplo: 2500012025");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre.trim();
        if (nombre.length() < 5 || !nombre.matches("^[a-zA-Z]+$")) { //matches indica si la cadena coincide o no con la expresión regular dada
            throw new IllegalArgumentException("El nombre debe tener solo letras y al menos 5 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        carrera = carrera.trim();
        if (carrera.length() <= 5 || !carrera.matches("^[a-zA-Z]+$")) { 
            throw new IllegalArgumentException("La carrera debe tener solo letras y al menos 5 caracteres.");
        }
        this.carrera = carrera;
    }

    public String toString() {
        return "ID: " + id + ", Nombre:" + nombre + ", Carrera:" + carrera;
    }
}
