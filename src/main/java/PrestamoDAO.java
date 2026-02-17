import java.sql.*;
import java.time.LocalDateTime;

public class PrestamoDAO {
    public void nuevoPrestamo(int idU, int idE) throws SQLException {
        String sql = "INSERT INTO PRESTAMOS (fechaSalida, fechaLimite, idUsuario, idEquipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            LocalDateTime ahora = LocalDateTime.now();
            ps.setTimestamp(1, Timestamp.valueOf(ahora));
            ps.setTimestamp(2, Timestamp.valueOf(ahora.plusDays(7))); // 7 días de límite
            ps.setInt(3, idU);
            ps.setInt(4, idE);
            ps.executeUpdate();
        }
    }
}