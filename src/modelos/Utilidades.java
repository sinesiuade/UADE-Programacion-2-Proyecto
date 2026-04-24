package modelos;

import interfaces.estructuras.I_ColaPedidos;
import interfaces.estructuras.I_ConjuntoEstaticoMateria;
import modelos.estructuras.ColaPedidos;
import modelos.estructuras.ConjuntoEstaticoMateria;

public class Utilidades {
    static public I_ConjuntoEstaticoMateria copiarConjunto(I_ConjuntoEstaticoMateria original) {
        I_ConjuntoEstaticoMateria copia = new ConjuntoEstaticoMateria();
        copia.inicializar();
        I_ConjuntoEstaticoMateria aux = new ConjuntoEstaticoMateria();
        aux.inicializar();

        while (!original.estaVacio()) {
            Materia m = original.elegir();
            aux.agregar(m);
            copia.agregar(m);
            original.sacar(m);
        }

        while (!aux.estaVacio()) {
            Materia m = aux.elegir();
            original.agregar(m);
            aux.sacar(m);
        }

        return copia;
    }

    static public I_ColaPedidos copiarCola(I_ColaPedidos original) {
        I_ColaPedidos copia = new ColaPedidos();
        copia.inicializar();

        I_ColaPedidos aux = new ColaPedidos();
        aux.inicializar();

        while (!original.estaVacia()) {
            PedidoDeInscripcion p = original.primero();
            copia.acolar(p);
            aux.acolar(p);
            original.desencolar();
        }

        while (!aux.estaVacia()) {
            original.acolar(aux.primero());
            aux.desencolar();
        }

        return copia;
    }
}
