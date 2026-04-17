package interfaces.estructuras;

import Materia;

public interface I_ConjuntoMaterias {
    void inicializar(); // pre: no aplica

    boolean agregar(Materia materia); // pre: conjunto inicializado, retorna false si ya existe o está lleno

    void quitar(String nombre); // pre: conjunto inicializado

    boolean pertenece(String nombre); // pre: conjunto inicializado

    boolean estaVacio(); // pre: conjunto inicializado

    Materia[] obtenerTodas(); // pre: conjunto inicializado
}
