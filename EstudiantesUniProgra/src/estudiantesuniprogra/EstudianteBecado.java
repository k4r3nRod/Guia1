/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiantesuniprogra;

/**
 *
 * @author karen
 */
public class EstudianteBecado extends Estudiante{
    protected double porcentajeBeca=0;

    public EstudianteBecado() {
    }

    public EstudianteBecado(String id, String nombre, String carrera, double porcentajeBeca){
        super(id, nombre, carrera);
        
        if (porcentajeBeca < 0 || porcentajeBeca > 100) {
            throw new IllegalArgumentException("Porcentaje de beca debe estar entre 0 y 100.");
        }else{
        this.porcentajeBeca = porcentajeBeca;
        }
    }
    
    public String toString() {
        return super.toString() + "," + porcentajeBeca;
    }    
}
