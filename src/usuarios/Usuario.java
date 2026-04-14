package usuarios;

public class Usuario {

    private int documento;
    private String nombre;
    private String apellido;


    public void SetDocumento(int documento){
        this.documento = documento;
    }


    public void SetNombre(String nombre){
        this.nombre = nombre;
    }

    public void SetApellido (String apellido){
        this.apellido = apellido;
    }

    public int GetDocumento(int documento){
        return documento;
    }

    public String GetNombre(String nombre){
        return nombre;
    }

    public String GetApellido(String apellido)

}

