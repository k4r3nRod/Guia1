/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiantesuniprogra;

/**
 *
 * @author karen
 */
public class EstudianteGeneral extends Estudiante {

    public EstudianteGeneral() {
    }

    public EstudianteGeneral(String id, String nombre, String carrera) {
        super(id, nombre, carrera);
    }

    @Override
    public String toString() {
        return super.toString() + ", General";
    }
}
