public class Puesto {
    private int idPuesto;
    private int numeroPuesto;
    private int idAula;
    private boolean ocupado;

    // Constructor
    public Puesto(int idPuesto, int numeroPuesto, int idAula, boolean ocupado) {
        this.idPuesto = idPuesto;
        this.numeroPuesto = numeroPuesto;
        this.idAula = idAula;
        this.ocupado = ocupado;
    }

    // Constructor sin ID 
    public Puesto(int numeroPuesto, int idAula, boolean ocupado) {
        this.numeroPuesto = numeroPuesto;
        this.idAula = idAula;
        this.ocupado = ocupado;
    }

    // Getters y Setters
    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    //MÉTODOS
    // Método para liberar el puesto
    public void liberar() {
        this.ocupado = false;
    }

    // Método para ocupar el puesto
    public void ocupar() {
        this.ocupado = true;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "idPuesto=" + idPuesto +
                ", numeroPuesto=" + numeroPuesto +
                ", idAula=" + idAula +
                ", ocupado=" + (ocupado ? "SÍ" : "NO") +
                '}';
    }
}