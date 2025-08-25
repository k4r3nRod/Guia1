/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiantesuniprogra;

/**
 *
 * @author karen
 */
public class EstudiantesUniProgra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            // metodo que carga los estudiantes ya existenrte
            registro.cargarEstudiantes(); 

            // para agregar nuevos estudiantes
            registro.agregarEstudiante("9", "karen", "Ingenieria");
            registro.agregarEstudiante("10", "cris", "Medicina", 50);
            registro.agregarEstudiante("11", "cris", "Medicina", 50);

            // guardar el archivo
            registro.guardarEstudiantes();

            // para cargar los nuevos que se añadieron
            registro = new RegistroEstudiantes();
            registro.cargarEstudiantes();

            // mostrar todos los estudiantes cargados
            registro.mostrarEstudiantes();

        } catch (IllegalArgumentException ex) {
            System.out.println("x| ---- Error al agregar estudiante: " + ex.getMessage());
        }

    }
    
}
