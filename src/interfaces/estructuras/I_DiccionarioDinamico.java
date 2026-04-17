package interfaces.estructuras;

import modelos.usuario.Usuario;

public interface I_DiccionarioDinamico {
    void inicializar(); // pre: no aplica

    void agregar(int clave, Usuario usuario); // pre: dic inicializado

    void eliminar(int clave); // pre: dic inicializado y clave existente

    Usuario recuperar(int clave); // pre: dic inicializado y clave existente

    I_ConjuntoEstaticoInt claves(); // pre: dic inicializado
}
