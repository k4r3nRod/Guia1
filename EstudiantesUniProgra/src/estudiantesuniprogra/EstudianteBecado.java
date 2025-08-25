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
    private double porcentajeBeca;

    public EstudianteBecado(String id, String nombre, String carrera, double porcentajeBeca) {
        super(id, nombre, carrera);
        setPorcentajeBeca(porcentajeBeca);
    }

    public double getPorcentajeBeca(){ 
        return porcentajeBeca; 
    }

    public void setPorcentajeBeca(double porcentajeBeca) {
        if (porcentajeBeca < 0 || porcentajeBeca > 100) {
            throw new IllegalArgumentException("Porcentaje de beca debe estar entre 0 y 100");
        }
        this.porcentajeBeca = porcentajeBeca;
    }

    @Override
    public String toString() {
        return super.toString() + "| Becado: " + porcentajeBeca;
    }
}
