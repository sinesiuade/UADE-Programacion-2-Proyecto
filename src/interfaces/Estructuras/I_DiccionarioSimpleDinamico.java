package interfaces.estructuras;

import interfaces.I_Estudiante;
import modelos.estructuras.Nodo_Estudiante;

public interface I_DiccionarioSimpleDinamico {
    void inicializar();// pre: no aplica

    void agregar(int clave, I_Estudiante estudiante_nuevo);// pre: dic inicializado

    void eliminar(int clave);// pre: dic inicializado

    I_Estudiante recuperar(int clave);// pre: dic inicializado y clave existe
}