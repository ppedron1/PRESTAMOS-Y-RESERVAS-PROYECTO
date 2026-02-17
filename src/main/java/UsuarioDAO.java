import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public void insertarAlumno(Alumno a) throws SQLException {
        String sql = "INSERT INTO USUARIOS (DNI, nombre, apellido, email, idTipo, exp) VALUES (?, ?, ?, ?, 1, ?)";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getExpediente());
            ps.executeUpdate();
        }
    }
}