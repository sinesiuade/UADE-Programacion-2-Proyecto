package interfaces.estructuras;

import modelos.Materia;

// Esta interfaz trabaja con el la materia como parametro que se envia como objeto total

public interface I_ConjuntoEstatico {

    void InicializarConjunto();

    void Agregar(Materia materia);

    Materia Elegir();

    boolean ConjuntoVacio();

    void Sacar(Materia materia);

    boolean Pertenece(Materia materia);
}