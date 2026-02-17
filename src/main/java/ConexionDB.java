import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mariadb://192.168.204.129:3306/DEBIANDB";
    private static final String USER = "pablo";
    private static final String PASS = "pablo";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MariaDB no encontrado en el proyecto: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}