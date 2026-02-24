public class Profesor extends Usuario {
    private String departamento;

    public Profesor(int id, String dni, String nombre, String apellido, String email, int telefonoOInt, String direccion, String departamento) {
        super(id, dni, nombre, apellido, email, 2,"");
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