package modelos.estructuras;

import modelos.usuario.Usuario;

public class NodoClaveUsuario {
    private int clave;
    private Usuario usuario;
    private NodoClaveUsuario siguiente;

    public int getClave() {
        return this.clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public NodoClaveUsuario getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(NodoClaveUsuario siguiente) {
        this.siguiente = siguiente;
    }
}
