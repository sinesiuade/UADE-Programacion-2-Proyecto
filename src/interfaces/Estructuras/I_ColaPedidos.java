package interfaces.estructuras;

import modelos.PedidoDeInscripcion;

public interface I_ColaPedidos {
    void inicializar();

    boolean encolar(PedidoDeInscripcion pedido);

    void desencolar();

    boolean estaVacia();

    PedidoDeInscripcion primero();
}
