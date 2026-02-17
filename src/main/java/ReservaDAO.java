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
        try (Connection conn = ConexionDB.conectar(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n--- ESTADO DE AULAS ---");
            while (rs.next()) {
                String estado = rs.getBoolean("estaDisponible") ? "OCUPADA" : "LIBRE";
                System.out.println("ID: " + rs.getInt("idAula") + " | " + rs.getString("nombreAula") + " | " + estado);
            }
        }
    }
}