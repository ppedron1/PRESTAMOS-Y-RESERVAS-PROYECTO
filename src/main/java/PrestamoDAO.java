import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
    // para estadisticas Xpath
public void informeEquiposMasPrestados() throws SQLException {
    String sql = "SELECT idEquipo, COUNT(*) as total FROM PRESTAMOS GROUP BY idEquipo ORDER BY total DESC";
    try (Connection conn = ConexionDB.conectar(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
        System.out.println("\n--- EQUIPOS MÁS SOLICITADOS ---");
        while (rs.next()) {
            System.out.println("ID Equipo: " + rs.getInt("idEquipo") + " | Veces prestado: " + rs.getInt("total"));
        }
    }
}
}