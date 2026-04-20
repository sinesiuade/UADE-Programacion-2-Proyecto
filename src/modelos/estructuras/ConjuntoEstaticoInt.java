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

    // implementacion dinamica

    // private class Nodo{
    // Materia valor;
    // Nodo sig;
    // }

    // private Nodo primero;
    // private int cant;
    // private static final int MAX = 100;

    // public void inicializar(){
    // primero = null;
    // cant = 0;
    // }

    // public void agregar(Materia materia ){
    // if (!pertenece(materia) && cant < MAX){
    // Nodo nuevo = new Nodo();
    // nuevo.valor = materia;
    // nuevo.sig = primero;
    // primero = nuevo;
    // cant++;

    // }
    // }

    // public boolean estaVacio(){
    // return primero == null;
    // }

    // public boolean pertenece(Materia materia){
    // Nodo actual =primero;

    // while(actual!=null){
    // if (actual.valor.getId() == materia.getId()){
    // return true;
    // }
    // actual = actual.sig;
    // }
    // return false;
    // }

    // public void sacar(Materia materia){
    // if (primero != null) {
    // if (primero.valor.getId() == materia.getId()) {
    // primero = primero.sig;
    // cant--;
    // } else {
    // Nodo actual = primero;

    // while (actual.sig != null &&
    // actual.sig.valor.getId() != materia.getId()) {
    // actual = actual.sig;
    // }

    // if (actual.sig != null) {
    // actual.sig = actual.sig.sig;
    // cant--;
    // }
    // }
    // }
    // }

    // public Materia elegir() {
    // return estaVacio() ? null : primero.valor;
    // }

}
