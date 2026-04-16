package modelos.estructuras;

import modelos.usuario.Usuario;

public class NodoDiccionario {
    private int clave = 0;
    private Usuario usuario = null;
    private NodoDiccionario siguiente = null;

    public NodoDiccionario(Usuario usuario) {
        clave = usuario.getDocumento();
        this.usuario = usuario;
        siguiente = null;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setSiguiente(NodoDiccionario siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDiccionario getSiguiente() {
        return this.siguiente;
    }

    public Usuario buscarDni(int dni) {
        if (clave == dni) {
            return usuario;
        } else {
            if (siguiente != null) {
                return siguiente.buscarDni(dni);
            } else {
                return null;
            }
        }
    }

    public void eliminarUsuario(int dni) {
        if (clave == dni) {
            usuario = null;
        } else {
            if (siguiente != null) {
                if (siguiente.getClave() == dni && siguiente.getSiguiente() == null) {
                    siguiente = siguiente.getSiguiente();
                    System.out.println("Usuario " + siguiente.getUsuario().getNombre() + " eliminado.");
                } else {
                    if (siguiente.getClave() == dni) {
                        siguiente = null;
                        System.out.println("Usuario " + siguiente.getUsuario().getNombre() + " eliminado.");
                    } else {
                        siguiente.eliminarUsuario(dni);
                    }
                }
            }
        }
    }

    public void agregarUsuario(Usuario usuario) {
        if (clave == 0) {
            clave = usuario.getDocumento();
            this.usuario = usuario;
        } else {
            if (siguiente == null) {
                NodoDiccionario nuevoNodo = new NodoDiccionario(usuario);
                siguiente = nuevoNodo;
            } else {
                siguiente.agregarUsuario(usuario);
            }
        }
    }

}
