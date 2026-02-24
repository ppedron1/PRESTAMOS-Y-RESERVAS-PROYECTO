public class Alumno extends Usuario {
    private String expediente;

    public Alumno(int id, String dni, String nombre, String apellido, String email, String expediente) {
        super(id, dni, nombre, apellido, email,1, "");
        this.expediente = expediente;
    }
    
    // Getters y Setters
    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + idUsuario +
                ", DNI='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", expediente='" + expediente + '\'' +
                '}';
    }
}