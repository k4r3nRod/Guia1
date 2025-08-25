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
        Scanner sc = new Scanner(System.in);
        RegistroEstudiantes registro = new RegistroEstudiantes();
        registro.cargarEstudiantes();

        boolean salir = false; //para controlar eel bucle del menu

        while (!salir) {
            System.out.println("\nBienvenido al registro de estudiantes");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Ver listado de estudiantes");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            double porcentajeBeca = -1;

            switch (opcion) {
                case 1:
                    boolean continuar = true;
                    while (continuar) {
                        try {
                            Estudiante est = new Estudiante();

                            // === ID ===
                            while (true) {
                                try {
                                    System.out.print("ID: ");
                                    String id = sc.nextLine();
                                    est.setId(id); // valida aquí mismo
                                    break; // si no lanza error, sale del bucle
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            // === Nombre ===
                            while (true) {
                                try {
                                    System.out.print("Nombre: ");
                                    String nombre = sc.nextLine();
                                    est.setNombre(nombre);
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            // === Carrera ===
                            while (true) {
                                try {
                                    System.out.print("Carrera: ");
                                    String carrera = sc.nextLine();
                                    est.setCarrera(carrera);
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            while (true) {
                                try {
                                    System.out.print("Porcentaje de beca (0 si es estudiante general): ");
                                    porcentajeBeca = sc.nextDouble();
                                    sc.nextLine(); // limpiar buffer

                                    if (porcentajeBeca < 0 || porcentajeBeca > 100) {
                                        throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
                                    }

                                    if (porcentajeBeca == 0) {
                                        // Estudiante General
                                        registro.agregarEstudiante(est.getId(), est.getNombre(), est.getCarrera());
                                        System.out.println("Estudiante General registrado.");
                                    } else {
                                        // Estudiante Becado
                                        registro.agregarEstudiante(est.getId(), est.getNombre(), est.getCarrera(), porcentajeBeca);
                                        System.out.println("Estudiante Becado registrado.");
                                    }
                                    break; // salir del while si todo salió bien

                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                    sc.nextLine(); // limpiar buffer si meten texto
                                }
                            }

                            String otro = "";
                            while (true) {
                                System.out.print("Desea ingresar otro estudiante? (s/n): ");
                                otro = sc.nextLine().trim().toLowerCase();

                                if (otro.equals("s") || otro.equals("n")) {
                                    if (!otro.equalsIgnoreCase("s")) {
                                        continuar = false;
                                    }
                                    break;
                                } else {
                                    System.out.println("Entrada invalida. Por favor escriba 's' para SI o 'n' para NO.");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error inesperado: " + e.getMessage());
                        }
                    }
                    registro.guardarEstudiantes();
                    break;
                case 2:
                    registro.mostrarEstudiantes();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Error inesperado, Opcion invalida");
            }
        }
        sc.close();
    }
}
