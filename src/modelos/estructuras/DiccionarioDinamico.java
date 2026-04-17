package modelos.estructuras;

import interfaces.estructuras.I_ConjuntoEstaticoInt;
import interfaces.estructuras.I_DiccionarioDinamico;
import modelos.usuario.Usuario;

public class DiccionarioDinamico implements I_DiccionarioDinamico {
    private NodoClaveUsuario origen;

    public void inicializar() {
        this.origen = null;
    }

    public void agregar(int clave, Usuario usuario) {
        NodoClaveUsuario nodo_clave = getNodoPorClave(clave);
        if (nodo_clave == null) {
            nodo_clave = new NodoClaveUsuario();
            nodo_clave.setClave(clave);
            nodo_clave.setNodoSiguiente(this.origen);
            this.origen = nodo_clave;
        }
        nodo_clave.setUsuario(usuario);
    }

    private NodoClaveUsuario getNodoPorClave(int clave) {
        NodoClaveUsuario nodo_aux = origen;
        while (nodo_aux != null && nodo_aux.getClave() != clave) {
            nodo_aux = nodo_aux.getNodoSiguiente();
        }
        return nodo_aux;
    };

    public void eliminar(int clave) {
        if (this.origen != null) {
            if (this.origen.getClave() == clave) {
                this.origen = this.origen.getNodoSiguiente();
            } else {
                NodoClaveUsuario nodo_aux = this.origen;
                while (nodo_aux.getNodoSiguiente() == null && nodo_aux.getNodoSiguiente().getClave() != clave) {
                    nodo_aux = nodo_aux.getNodoSiguiente();
                }
                if (nodo_aux.getNodoSiguiente() != null) {
                    nodo_aux.setNodoSiguiente(nodo_aux.getNodoSiguiente().getNodoSiguiente());
                }
            }
        }
    }

    public Usuario recuperar(int clave) {
        NodoClaveUsuario nodo_clave = getNodoPorClave(clave);
        return nodo_clave.getUsuario();
    }

    public I_ConjuntoEstaticoInt claves() {
        I_ConjuntoEstaticoInt ret = new ConjuntoEstaticoInt();
        ret.inicializar();
        NodoClaveUsuario nodo_aux = origen;
        while (nodo_aux != null) {
            ret.agregar(nodo_aux.getClave());
            nodo_aux = nodo_aux.getNodoSiguiente();
        }
        return ret;
    }
}
