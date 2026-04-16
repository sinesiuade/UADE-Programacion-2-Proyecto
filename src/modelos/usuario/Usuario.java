package modelos.usuario;

public class Usuario {

    protected int documento;
    protected String nombre;
    protected String apellido;

    public void SetDocumento(int documento) {
        this.documento = documento;
    }

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetApellido(String apellido) {
        this.apellido = apellido;
    }

    public int GetDocumento() {
        return documento;
    }

    public String GetNombre() {
        return nombre;
    }

    public String GetApellido() {
        return apellido;
    }

}