package modelos.usuario;

import modelos.Materia;

public class Usuario {

    protected int documento;
    protected String nombre;
    protected String apellido;
    protected String contrasena;

    public Usuario() {
    }

    public Usuario(int documento, String nombre, String apellido, String contrasena) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String to_String() {

        return "DNI: " + documento + " | Nombre: " + nombre + " | Apellido: " + apellido;
    }
}