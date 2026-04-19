package modelos.estructuras;

import Materia;
import interfaces.estructuras.I_ConjuntoMaterias;

public class O_ConjuntoMaterias_arr implements I_ConjuntoMaterias {
    private static final int CAPACIDAD = 100;
    private Materia[] elementos;
    private int cantidad;

    @Override
    public void inicializar() {
        this.elementos = new Materia[CAPACIDAD];
        this.cantidad = 0;
    }

    @Override
    public boolean agregar(Materia materia) {
        if (cantidad == CAPACIDAD || pertenece(materia.getNombre())) {
            return false;
        }
        elementos[cantidad] = materia;
        cantidad++;
        return true;
    }

    @Override
    public void quitar(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i].getNombre().equals(nombre)) {
                elementos[i] = elementos[cantidad - 1];
                elementos[cantidad - 1] = null;
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean pertenece(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estaVacio() {
        return cantidad == 0;
    }

    @Override
    public Materia[] obtenerTodas() {
        Materia[] resultado = new Materia[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = elementos[i];
        }
        return resultado;
    }
}
