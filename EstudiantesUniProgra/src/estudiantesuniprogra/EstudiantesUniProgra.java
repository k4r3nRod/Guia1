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
                
                // === ID ===
                while (true) {
                    try {
                        System.out.print("Ingrese ID, ejemplo, 2500012025: ");
                        id = sc.nextLine();
                        if (id == null || !id.matches("\\d{10}")) {
                            throw new IllegalArgumentException("El ID debe tener exactamente 10 iígitos.");
                        }
                        break; // si no lanza error, sale del bucle
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                            
                // === Nombre ===
                while (true) {
                    try {
                        System.out.print("Ingrese Nombre (mínimo 5 letras): ");
                        nombre = sc.nextLine();
                        nombre = nombre.trim();
                        if (nombre.length() < 5 || !nombre.matches("^[a-zA-Z]+$")) { //matches indica si la cadena coincide o no con la expresión regular dada
                            throw new IllegalArgumentException("El nombre debe tener solo letras y al menos 5 caracteres.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                // === Carrera ===
                while (true) {
                    try {
                        System.out.print("Ingrese Carrera (mínimo 5 letras): ");
                        carrera = sc.nextLine();
                        carrera = carrera.trim();
                        if (carrera.length() <= 5 || !carrera.matches("^[a-zA-Z]+$")) { 
                            throw new IllegalArgumentException("La carrera debe tener solo letras y al menos 5 caracteres.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                
                
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
