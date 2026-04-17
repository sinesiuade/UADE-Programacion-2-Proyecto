package interfaces.estructuras;

import modelos.Materia;

// Esta interfaz trabaja con el la materia como parametro que se envia como objeto total

public interface I_ConjuntoEstaticoInt {

    void inicializar();

    void agregar(int valor);

    int elegir();

    boolean estaVacio();

    void sacar(int valor);

    boolean pertenece(int valor);
}