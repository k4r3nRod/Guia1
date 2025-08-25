/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiantesuniprogra;

import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        String continuar = "s", id = "SIN ESPECIFICAR", nombre = "SIN ESPECIFICAR", carrera = "SIN ESPECIFICAR";

        registro.cargarEstudiantes();

        while (continuar.equalsIgnoreCase("s")) {
            try {
                System.out.println("\n--- Registro de Estudiantes ---");
                
                System.out.print("Ingrese ID (10 dígitos): ");
                id = sc.nextLine();
                if (id == null || !id.matches("\\d{10}")) {
                    throw new IllegalArgumentException("El ID debe tener exactamente 10 dígitos.");
                }
                
                System.out.print("Ingrese Nombre (mínimo 5 letras): ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese Carrera (mínimo 5 letras): ");
                String carrera = sc.nextLine();
                System.out.print("Ingrese porcentaje de beca (0 para estudiante general): ");

                String becaTexto = sc.nextLine();
                double beca = Double.parseDouble(becaTexto); // Puede lanzar NumberFormatException

                if (beca == 0) {
                    registro.agregarEstudiante(id, nombre, carrera);
                } else {
                    registro.agregarEstudiante(id, nombre, carrera, beca);
                }

                System.out.print("¿Desea agregar otro estudiante? (s/n): ");
                continuar = sc.nextLine();

            } catch (NumberFormatException e) {
                System.out.println("x Error: El porcentaje debe ser un número.");
                // vuelve al inicio del while
            } catch (IllegalArgumentException e) {
                System.out.println("x Error: " + e.getMessage());
                System.out.println("Intente nuevamente.\n");
            }
        }

        registro.guardarEstudiantes();
        registro.mostrarEstudiantes();
        sc.close();

    }

}
