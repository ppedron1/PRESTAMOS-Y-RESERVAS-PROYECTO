import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO uDAO = new UsuarioDAO();
        ReservaDAO rDAO = new ReservaDAO();
        PrestamoDAO pDAO = new PrestamoDAO();
        ExportadorXML xDAO = new ExportadorXML();
        
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== GESTIÓN AULAS Y PORTÁTILES =====");
            System.out.println("1. Alta Alumno");
            System.out.println("2. Ver Estado de Aulas (Resumen Visual)");
            System.out.println("3. Reservar Aula");
            System.out.println("4. Prestar Equipo");
            System.out.println("5. Exportar Reservas a XML");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("DNI: "); String dni = sc.nextLine();
                        System.out.print("Nombre: "); String nom = sc.nextLine();
                        System.out.print("Expediente: "); String exp = sc.nextLine();
                        uDAO.insertarAlumno(new Alumno(0, dni, nom, "", "", exp));
                        System.out.println("Alumno creado.");
                        break;
                    case 2:
                        rDAO.mostrarAulas(); 
                        break;
                    case 3:
                        System.out.print("ID Usuario: "); int idU = Integer.parseInt(sc.nextLine());
                        System.out.print("ID Aula: "); int idA = Integer.parseInt(sc.nextLine());
                        rDAO.hacerReserva(idU, idA); 
                        System.out.println("Reserva realizada.");
                        break;
                    case 4:
                        System.out.print("ID Usuario: "); int uP = Integer.parseInt(sc.nextLine());
                        System.out.print("ID Equipo: "); int eP = Integer.parseInt(sc.nextLine());
                        pDAO.nuevoPrestamo(uP, eP); // Punto 3 del PDF [cite: 31]
                        System.out.println("Préstamo registrado.");
                        break;
                    case 5:
                        xDAO.generarXMLReservas(); 
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}