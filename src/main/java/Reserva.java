import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private LocalDateTime fecha;
    private int idUsuario;
    private int idAula;

    public Reserva(int id, LocalDateTime fecha, int idUsuario, int idAula) {
        this.idReserva = id;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idAula = idAula;
    }
    
    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }
}