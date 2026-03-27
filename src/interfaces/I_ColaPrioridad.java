package interfaces;

public interface I_ColaPrioridad {
    void inicializar();

    void encolar(int valor, int prioridad);

    void desencolar();

    Boolean estaVacia();

    int primero();

    int prioridadPrimero();
}
