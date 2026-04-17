package modelos.usuario;

public class Admin extends Usuario {
    public Admin(int documento, String contraseña, String apellido, String nombre) {
        super(documento, nombre, apellido, contraseña);
    }

}
