package interfaces.estructuras;

public interface I_ConjuntoEstaticoInt {

    void inicializar();

    void agregar(int valor);

    int elegir();

    boolean estaVacio();

    void sacar(int valor);

    boolean pertenece(int valor);
}