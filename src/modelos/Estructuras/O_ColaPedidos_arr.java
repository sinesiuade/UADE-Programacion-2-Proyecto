package modelos.estructuras;

import modelos.PedidoDeInscripcion;
import interfaces.estructuras.I_ColaPedidos;

public class O_ColaPedidos_arr implements I_ColaPedidos {
    private PedidoDeInscripcion[] elementos;
    private int frente;
    private int fin;
    private int cantidad;

    @Override
    public void inicializar() {
        this.elementos = new PedidoDeInscripcion[100];
        this.frente = 0;
        this.fin = 0;
        this.cantidad = 0;
    }

    @Override
    public boolean encolar(PedidoDeInscripcion pedido) {
        if (cantidad == 100) {
            return false;
        }
        elementos[fin] = pedido;
        fin = (fin + 1) % 100;
        cantidad++;
        return true;
    }

    @Override
    public PedidoDeInscripcion primero() {
        if (estaVacia()) {
            return null;
        }
        return elementos[frente];
    }

    @Override
    public void desencolar() {
        if (estaVacia()) {
            return;
        }
        elementos[frente] = null;
        frente = (frente + 1) % 100;
        cantidad--;
    }

    @Override
    public boolean estaVacia() {
        return cantidad == 0;
    }
}
