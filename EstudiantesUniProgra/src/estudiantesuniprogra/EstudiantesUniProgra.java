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
        Scanner sc = new Scanner(System.in);
        RegistroEstudiantes registro = new RegistroEstudiantes();
        registro.cargarEstudiantes();

        boolean salir = false;
        while (!salir) {
            System.out.println("\nBienvenido al registro de estudiantes");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Ver listado de estudiantes");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    boolean continuar = true;
                    while (continuar) {
                        try {
                            System.out.print("ID: "); String id = sc.nextLine();
                            System.out.print("Nombre: "); String nombre = sc.nextLine();
                            System.out.print("Carrera: "); String carrera = sc.nextLine();
                            System.out.print("¿Es becado? (s/n): "); String beca = sc.nextLine();

                            if (beca.equalsIgnoreCase("s")) {
                                System.out.print("Porcentaje de beca: ");
                                double porcentaje = sc.nextDouble();
                                sc.nextLine();
                                registro.agregarEstudiante(id, nombre, carrera, porcentaje);
                            } else {
                                registro.agregarEstudiante(id, nombre, carrera);
                            }

                            System.out.print("¿Desea ingresar otro estudiante? (s/n): ");
                            String respuesta = sc.nextLine();
                            if (!respuesta.equalsIgnoreCase("s")) {
                                continuar = false;
                            }

                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    registro.guardarEstudiantes();
                }
                case 2 -> registro.mostrarEstudiantes();
                case 3 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
