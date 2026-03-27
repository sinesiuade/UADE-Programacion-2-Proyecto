package modelos;

import interfaces.I_Elemento;

public class O_Elemento implements I_Elemento {
    private int valor;
    private int prioridad;

    @Override
    public void cargar(int valor, int prioridad) {
        this.valor = valor;
        this.prioridad = prioridad;
    }

    @Override
    public int getValor() {
        return this.valor;
    }

    @Override
    public int getPrioridad() {
        return this.prioridad;
    }
}
