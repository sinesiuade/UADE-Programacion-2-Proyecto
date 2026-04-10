package modelos.Estructuras;

import interfaces.I_ColaPrioridad;

public class O_ColaPrioridad_doble_arr implements I_ColaPrioridad {
    private int[] elementos;
    private int[] prioridades;
    private int indice;

    @Override
    public void inicializar() {
        this.elementos = new int[100];
        this.prioridades = new int[100];
        this.indice = 0;
    }

    @Override
    public void encolar(int valor, int prioridad) {
        int j = indice;
        while (j > 0 && this.prioridades[j - 1] > prioridad) {
            this.elementos[j] = this.elementos[j - 1];
            this.prioridades[j] = this.prioridades[j - 1];
            j--;
        }
        this.elementos[j] = valor;
        this.prioridades[j] = prioridad;
        this.indice++;
    }

    @Override
    public void desencolar() {
        if (!estaVacia()) {
            this.indice--;
        }
    }

    @Override
    public Boolean estaVacia() {
        return (this.indice == 0);
    }

    @Override

    public int primero() {
        return this.elementos[indice - 1];
    }

    @Override
    public int prioridadPrimero() {
        return this.prioridades[indice - 1];
    }
}