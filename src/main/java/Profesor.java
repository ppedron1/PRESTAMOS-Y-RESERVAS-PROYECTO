public class Profesor extends Usuario {
    private String departamento;

    public Profesor(int id, String dni, String nombre, String apellido, String email, String departamento) {
        super(id, dni, nombre, apellido, email);
        this.departamento = departamento;
    }
    
    //GETTERS Y SETTERS
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}