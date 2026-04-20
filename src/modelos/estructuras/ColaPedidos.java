package modelos.estructuras;

import interfaces.estructuras.I_ColaPedidos;
import modelos.PedidoDeInscripcion;

public class ColaPedidos implements I_ColaPedidos {
    PedidoDeInscripcion[] arr;
    int inx;

    public void inicializar() {
        arr = new PedidoDeInscripcion[100];
        inx = 0;
    }

    public void acolar(PedidoDeInscripcion pedido) {
        for (int i = inx - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = pedido;
        inx++;
    }

    public void desencolar() {
        inx--;
    }

    public boolean estaVacia() {
        return (inx == 0);
    }

    public PedidoDeInscripcion primero() {
        return arr[inx - 1];
    }
}
