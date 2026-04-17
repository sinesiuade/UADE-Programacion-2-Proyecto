package interfaces.estructuras;

import modelos.Materia;

// Esta interfaz trabaja con el la materia como parametro que se envia como objeto total

public interface I_ConjuntoEstaticoMateria {

    void inicializar();

    void agregar(Materia materia);

    Materia elegir();

    boolean estaVacio();

    void sacar(Materia materia);

    boolean pertenece(Materia materia);
}