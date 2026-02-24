import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReservaDAO {
    public void hacerReserva(int idU, int idA) throws SQLException {
        String sqlReserva = "INSERT INTO RESERVAS (fecha, idUsuario, idAula) VALUES (?, ?, ?)";
        String sqlAula = "UPDATE AULAS SET estaDisponible = FALSE WHERE idAula = ?";
        
        try (Connection conn = ConexionDB.conectar()) {
            // Registrar la reserva
            PreparedStatement psR = conn.prepareStatement(sqlReserva);
            psR.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            psR.setInt(2, idU);
            psR.setInt(3, idA);
            psR.executeUpdate();

            // Marcar aula como ocupada
            PreparedStatement psA = conn.prepareStatement(sqlAula);
            psA.setInt(1, idA);
            psA.executeUpdate();
        }
    }

    public void mostrarAulas() throws SQLException {
    String sql = "SELECT idAula, nombreAula, estaDisponible FROM AULAS";
    try (Connection conn = ConexionDB.conectar(); 
        Statement st = conn.createStatement(); 
        ResultSet rs = st.executeQuery(sql)) {
        
        System.out.println("\n--- ESTADO DE AULAS ---");
        while (rs.next()) {
            String estado = rs.getBoolean("estaDisponible") ? "LIBRE" : "OCUPADA";
            System.out.println("ID: " + rs.getInt("idAula") + " | " + rs.getString("nombreAula") + " | " + estado);
        }
    }
}
// para las estadisticas
public void informeUsuariosMasActivos() throws SQLException {
    String sql = "SELECT idUsuario, COUNT(*) as total FROM RESERVAS GROUP BY idUsuario ORDER BY total DESC LIMIT 5";
    try (Connection conn = ConexionDB.conectar(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
        System.out.println("\n--- TOP USUARIOS CON MÁS RESERVAS ---");
        while (rs.next()) {
            System.out.println("ID Usuario: " + rs.getInt("idUsuario") + " | Total: " + rs.getInt("total"));
        }
    }
}
public void liberarAula(int idAula) throws SQLException {
    String sqlAula = "UPDATE AULAS SET estaDisponible = TRUE WHERE idAula = ?";
    
    try (Connection conn = ConexionDB.conectar(); 
        PreparedStatement psA = conn.prepareStatement(sqlAula)) {
        psA.setInt(1, idAula);
        int filasActualizadas = psA.executeUpdate();
        
        if (filasActualizadas > 0) {
            System.out.println("Aula " + idAula + " liberada con éxito. Vuelve a estar disponible.");
        } else {
            System.out.println("No se ha encontrado el aula o ya estaba libre.");
        }
    }
}
}