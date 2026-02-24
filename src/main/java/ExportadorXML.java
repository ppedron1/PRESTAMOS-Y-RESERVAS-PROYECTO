import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportadorXML {
    public void generarXMLReservas() {
        // El bloque try-with-resources gestiona el cierre de los 3 recursos
        try (Connection conn = ConexionDB.conectar();
            Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM RESERVAS");
            PrintWriter writer = new PrintWriter("reservas.xml")) {

            // Encabezado
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<reservas>");

            // Cuerpo
            while (rs.next()) {
                writer.println("  <reserva id=\"" + rs.getInt("idReserva") + "\">");
                writer.println("    <fecha>" + rs.getString("fecha") + "</fecha>");
                writer.println("  </reserva>");
            }

            // Cierre
            writer.println("</reservas>");
            System.out.println("Archivo 'reservas.xml' generado correctamente.");

        } catch (SQLException | IOException e) {
            System.err.println("Error en el proceso: " + e.getMessage());
        }
    }
    public void generarXMLPrestamos() {
    try (Connection conn = ConexionDB.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PRESTAMOS");
        PrintWriter writer = new PrintWriter("prestamos.xml")) {

        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<prestamos>");
        while (rs.next()) {
            writer.println("  <prestamo id=\"" + rs.getInt("idPrestamo") + "\">");
            writer.println("    <usuario>" + rs.getInt("idUsuario") + "</usuario>");
            writer.println("    <equipo>" + rs.getInt("idEquipo") + "</equipo>");
            writer.println("    <salida>" + rs.getString("fechaSalida") + "</salida>");
            writer.println("  </prestamo>");
        }
        writer.println("</prestamos>");
        System.out.println("Archivo 'prestamos.xml' generado correctamente.");
    } catch (SQLException | IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}