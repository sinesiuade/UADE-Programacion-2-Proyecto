package modelos.Estructuras;


import interfaces.Estructuras.I_ConjuntoEstatico;
import obj.Materia;// importo la materia


// Trabaja con la materia



public class SetEstaticoImp implements I_ConjuntoEstatico {
    private Materia[] a; // La cantidad de materias
    private int cant; // La cantidad de elementos


    public void InicializarConjunto() { 
        a = new Materia [100];
        cant = 0;
    }

    public void Agregar(Materia materia) {
        if (!this.Pertenece(materia)) { 
            a[cant] = materia;
            cant++; // Nuevo elemento
        }
    }

    public boolean ConjuntoVacio() {
        return (cant == 0);
    }

    public Materia Elegir() {
        return a[0];  // este es un criterio random si quieren cambiarlo es lo mismo se puede cualquier cosa en la implementacion
    }

    public boolean Pertenece(Materia materia) {
        int i = 0;
        while (i < cant && a[i] != materia) // Si no funciona hacer que sea por .getId()
            i++;
        return (i < cant);
    }

    public void Sacar(Materia materia) {
        int i = 0;
        while (i < cant && a[i] != materia)
            i++;
        if (i < cant) { 
            a[i] = a[cant - 1];
            cant--;
        }
    }
}