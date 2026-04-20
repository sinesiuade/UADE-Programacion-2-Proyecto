package modelos.estructuras;

import interfaces.estructuras.I_ConjuntoEstaticoMateria;
import modelos.Materia;

public class ConjuntoEstaticoMateria implements I_ConjuntoEstaticoMateria {
    private Materia[] a;
    private int cant;

    public void inicializar() {
        a = new Materia[100];
        cant = 0;
    }

    public void agregar(Materia materia) {
        // Dante: Se revisa si no se excede el array y si la materia no está ya en el
        // conjunto
        if (cant < 100 && !this.pertenece(materia)) {
            a[cant] = materia;
            cant++;
        }
    }

    public boolean estaVacio() {
        return (cant == 0);
    }

    public Materia elegir() {
        // Retorna el último elemento agregado para evitar siempre el índice 0
        // o null si está vacío para evitar excepciones.
        return estaVacio() ? null : a[cant - 1];
    }

    public boolean pertenece(Materia materia) {
        int i = 0;
        // Optimizamos la comparación usando el ID único de la materia
        while (i < cant && a[i].getId() != materia.getId()) {
            i++;
        }
        return (i < cant);
    }

    public void sacar(Materia materia) {
        int i = 0;
        while (i < cant && a[i].getId() != materia.getId()) {
            i++;
        }

        if (i < cant) {
            a[i] = a[cant - 1];
            a[cant - 1] = null;
            cant--;
        }
    }

    // Implementacion dinamica alternativa
    // private class Nodo {
    // int valor;
    // Nodo sig;
    // }
    //
    // private Nodo primero;
    // private int cant;
    // private static final int MAX = 100;
    //
    // public void inicializar() {
    // primero = null;
    // cant = 0;
    // }
    //
    // public void agregar(int valor) {
    // if (!pertenece(valor) && cant < MAX) {
    // Nodo nuevo = new Nodo();
    // nuevo.valor = valor;
    // nuevo.sig = primero;
    // primero = nuevo;
    // cant++;
    // }
    // }
    //
    // public boolean estaVacio() {
    // return primero == null;
    // }
    //
    // public int elegir() {
    // return estaVacio() ? 0 : primero.valor;
    // }
    //
    // public boolean pertenece(int valor) {
    // Nodo actual = primero;
    // while (actual != null) {
    // if (actual.valor == valor) {
    // return true;
    // }
    // actual = actual.sig;
    // }
    // return false;
    // }
    //
    // public void sacar(int valor) {
    // if (primero == null) {
    // return;
    // }
    //
    // if (primero.valor == valor) {
    // primero = primero.sig;
    // cant--;
    // return;
    // }
    //
    // Nodo actual = primero;
    // while (actual.sig != null && actual.sig.valor != valor) {
    // actual = actual.sig;
    // }
    //
    // if (actual.sig != null) {
    // actual.sig = actual.sig.sig;
    // cant--;
    // }
    // }

}