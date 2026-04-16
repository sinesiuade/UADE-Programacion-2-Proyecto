package modelos.estructuras;

import interfaces.estructuras.I_ConjuntoEstatico;
import modelos.Materia;

// Trabaja con la materia

public class ConjuntoEstatico implements I_ConjuntoEstatico {
    private Materia[] a; // La cantidad de materias
    private int cant; // La cantidad de elementos

    public void inicializar() {
        a = new Materia[100];
        cant = 0;
    }

    public void agregar(Materia materia) {
        if (!this.pertenece(materia)) {
            a[cant] = materia;
            cant++; // Nuevo elemento
        }
    }

    public boolean estaVacio() {
        return (cant == 0);
    }

    public Materia elegir() {
        return a[0]; // este es un criterio random si quieren cambiarlo es lo mismo se puede
                     // cualquier cosa en la implementacion
    }

    public boolean pertenece(Materia materia) {
        int i = 0;
        while (i < cant && a[i] != materia) // Si no funciona hacer que sea por .getId()
            i++;
        return (i < cant);
    }

    public void sacar(Materia materia) {
        int i = 0;
        while (i < cant && a[i] != materia)
            i++;
        if (i < cant) {
            a[i] = a[cant - 1];
            cant--;
        }
    }
}