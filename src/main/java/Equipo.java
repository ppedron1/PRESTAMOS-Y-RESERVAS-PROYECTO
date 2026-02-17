public abstract class Equipo {
    protected int idEquipo;
    protected String numeroMAC;
    protected String estado;

    public Equipo(int id, String mac, String estado) {
        this.idEquipo = id;
        this.numeroMAC = mac;
        this.estado = estado;
    }
    
    // Getters y Setters
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNumeroMAC() {
        return numeroMAC;
    }

    public void setNumeroMAC(String numeroMAC) {
        this.numeroMAC = numeroMAC;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}