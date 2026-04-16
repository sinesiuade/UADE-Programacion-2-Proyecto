package interfaces.estructuras;

import Pedido;

public interface I_ColaPedidos {
    void inicializar();

    boolean encolar(Pedido pedido);

    void desencolar();

    boolean estaVacia();

    Pedido primero();
}
