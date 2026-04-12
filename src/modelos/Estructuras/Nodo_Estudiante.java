package modelos.estructuras;

import Estudiante;
import interfaces.estructuras.I_Nodo_Estudiante;

public class Nodo_Estudiante implements I_Nodo_Estudiante {
    private int clave;
    private Estudiante estudiante;
    private Nodo_Estudiante siguiente;

    Nodo_Estudiante(Estudiante estudiante) {
        this.clave = estudiante.getDni();
        this.estudiante = estudiante;
        this.siguiente = null;
    }

    @Override
    public void cargarSiguiente(interfaces.estructuras.I_Nodo_Estudiante nodo) {
        this.siguiente = (Nodo_Estudiante) nodo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Nodo_Estudiante getSiguiente() {
        return siguiente;
    }
}
