import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO uDAO = new UsuarioDAO();
        ReservaDAO rDAO = new ReservaDAO();
        PrestamoDAO pDAO = new PrestamoDAO();
        ExportadorXML xDAO = new ExportadorXML();
        AnalizadorEstadisticas stats = new AnalizadorEstadisticas();
        
        System.out.println("\n===== BIENVENIDO AL SISTEMA =====");
        System.out.println("¿Qué tipo de usuario eres?");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        System.out.print("Selecciona tu tipo (1 o 2): ");
        int tipoUsuario = Integer.parseInt(sc.nextLine());
        
        if (tipoUsuario != 1 && tipoUsuario != 2) {
            System.out.println("Opción inválida. Por favor, selecciona 1 o 2.");
            sc.close();
            return;
        }
        
        String tipoUsuarioTexto = tipoUsuario == 1 ? "Alumno" : "Profesor";
        System.out.println("Conectado como: " + tipoUsuarioTexto + "\n");
        
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== GESTIÓN AULAS Y PORTÁTILES =====");
            System.out.println("1. Alta Alumno");
            System.out.println("2. Ver Estado de Aulas (Resumen Visual)");
            System.out.println("3. Reservar Aula");
            System.out.println("4. Prestar Equipo");
            System.out.println("5. Exportar Reservas y Prestamos a XML");
            System.out.println("6. Ver Estadísticas de Reservas por Día");
            System.out.println("7. Informes de Usuarios y Equipos");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("DNI: "); String dni = sc.nextLine();
                        System.out.print("Nombre: "); String nom = sc.nextLine();
                        System.out.print("Apellido: "); String apellido = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        System.out.print("ID Tipo (1-Alumno, 2-Profesor): "); int idTipo = Integer.parseInt(sc.nextLine());
                        System.out.print("Expediente: "); String exp = sc.nextLine();
                        uDAO.insertarAlumno(new Usuario(idTipo, dni, nom, apellido, email, idTipo, exp) {});
                        System.out.println("Usuario creado.");
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
                        pDAO.nuevoPrestamo(uP, eP); 
                        System.out.println("Préstamo registrado.");
                        break;
                    case 5:
                        xDAO.generarXMLReservas();
                        xDAO.generarXMLPrestamos();
                        break;
                    case 6:
                        System.out.print("Introduce fecha (YYYY-MM-DD) para estadísticas: ");
                        String fecha = sc.nextLine();
                        stats.contarReservasPorDia(fecha);
                        break;
                    case 7:
                        rDAO.informeUsuariosMasActivos();
                        pDAO.informeEquiposMasPrestados();
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