package modelos.Estructuras;

import interfaces.I_ColaPrioridad;
import interfaces.I_Elemento;

public class O_ColaPrioridad_obj implements I_ColaPrioridad {
    private I_Elemento[] elementos;
    private int indice;

    @Override
    public void inicializar() {
        this.elementos = new I_Elemento[100];
        this.indice = 0;
    }

    @Override
    public void encolar(int valor, int prioridad) {
        int j = indice;
        while (j > 0 && this.elementos[j - 1].getPrioridad() > prioridad) {
            this.elementos[j] = this.elementos[j - 1];
            j--;
        }
        this.elementos[j] = new O_Elemento();
        this.elementos[j].cargar(valor, prioridad);
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
        return this.elementos[indice - 1].getValor();
    }

    @Override
    public int prioridadPrimero() {
        return this.elementos[indice - 1].getPrioridad();
    }
}