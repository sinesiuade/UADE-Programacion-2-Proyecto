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

        // private Class Nodo{
    // int valor;
    // Nodo sig;
    // }
    // private Nodo primero;
    // private int cant;
    // private static final int MAX = 100;

    // public void inicializar(){
    // primero = null;
    // int cant;
    // }

    // public void agregar(int valor){
    // if(!pertenece(valor) && cant<MAX){
    // Nodo nuevo = new Nodo();
    // nuevo.valor = valor;
    // nuevo.sig = primero;
    // primero = nuevo;
    // cant++;
    // }
    // }

    // public void estavacio(){
    // return primero == null;
    // }

    // public void elegir(int valor){
    // return nuevo.primero;
    // }

    // public void pertenece(int valor){
    // Nodo actual = primero
    // while (actual != null ){
    // if(actual.valor == valor ){
    // return true;
    // }
    // actual = actual.sig;
    // }
    // return false;
    // }

    // public void sacar(){
    // if(primero != null){
    // if (primero.valor == valor){
    // primero = primero.sig;
    // cant--;
    // }else{
    // nodo actual = primero ;

    // while (actual.sig != null && actual.sig.valor != valor){
    // actual = actual.sig;
    // }

    // if(actual.sig!=null){
    // actual.sig=actual.sig.sig;
    // cant --
    // }
    // }
    // }
    // }
}
