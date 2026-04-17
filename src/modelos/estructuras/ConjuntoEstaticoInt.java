package modelos.estructuras;

import interfaces.estructuras.I_ConjuntoEstaticoInt;

public class ConjuntoEstaticoInt implements I_ConjuntoEstaticoInt {
    private int[] contenido;
    private int cant;

    public void inicializar() {
        this.contenido = new int[100];
        this.cant = 0;
    }

    public void agregar(int valor) {
        if (!this.pertenece(valor)) {
            this.contenido[this.cant] = valor;
            this.cant++;
        }
    }

    public int elegir() {
        return contenido[this.cant - 1];
    }

    public boolean estaVacio() {
        return cant == 0;
    }

    public void sacar(int valor) {
        int i = 0;
        while (i < this.cant && this.contenido[i] != valor) {
            i++;
        }
        if (i < this.cant) {
            this.contenido[i] = this.contenido[this.cant - 1];
            this.cant--;
        }

    }

    public boolean pertenece(int valor) {
        int i = 0;
        while (i < this.cant && this.contenido[i] != valor) {
            i++;
        }
        return i < this.cant;
    }
}
