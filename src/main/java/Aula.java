public class Aula {
    private int idAula;
    private String nombre;
    private boolean estaDisponible;

    public Aula(int id, String nombre, boolean disponible) {
        this.idAula = id;
        this.nombre = nombre;
        this.estaDisponible = disponible;
    }

    // Getters y Setters
    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
}