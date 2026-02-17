import java.time.LocalDateTime;

public class Prestamo {
    private int idPrestamo;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLimite;
    private LocalDateTime fechaDevolucion; 
    private int idUsuario;
    private int idEquipo;

    public Prestamo(int id, LocalDateTime salida, LocalDateTime limite, int idUser, int idEquip) {
        this.idPrestamo = id;
        this.fechaSalida = salida;
        this.fechaLimite = limite;
        this.idUsuario = idUser;
        this.idEquipo = idEquip;
    }

    // Getters y Setters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}