package modelos.estructuras;

import Pedido;
import interfaces.estructuras.I_ColaPedidos;

public class O_ColaPedidos_arr implements I_ColaPedidos {
    private Pedido[] elementos;
    private int frente;
    private int fin;
    private int cantidad;

    @Override
    public void inicializar() {
        this.elementos = new Pedido[100];
        this.frente = 0;
        this.fin = 0;
        this.cantidad = 0;
    }

    @Override
    public boolean encolar(Pedido pedido) {
        if (cantidad == 100) {
            return false;
        }
        elementos[fin] = pedido;
        fin = (fin + 1) % 100;
        cantidad++;
        return true;
    }

    @Override
    public Pedido primero() {
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
