package modelos.estructuras;

import interfaces.I_Estudiante;
import interfaces.estructuras.I_DiccionarioSimpleDinamico;

public class DiccionarioSimpleDinamico implements I_DiccionarioSimpleDinamico {
    private Nodo_Estudiante primer_nodo;

    @Override
    public void inicializar() {// pre: no aplica
        this.primer_nodo = null;
    }

    @Override
    public void agregar(int clave, I_Estudiante estudiante_nuevo) {
        Nodo_Estudiante nuevo_nodo = new Nodo_Estudiante(estudiante_nuevo);

        if (this.primer_nodo == null) {
            this.primer_nodo = nuevo_nodo;
        } else {
            Nodo_Estudiante nodo_actual = this.primer_nodo;
            while (nodo_actual.getSiguiente() != null) {
                nodo_actual = nodo_actual.getSiguiente();
            }
            nodo_actual.cargarSiguiente(nuevo_nodo);
        }
    }

    @Override
    public void eliminar(int clave) {
        if (this.primer_nodo != null) {
            if (this.primer_nodo.getEstudiante().getDni() == clave) {
                this.primer_nodo = this.primer_nodo.getSiguiente();
            } else {
                Nodo_Estudiante nodo_actual = this.primer_nodo;
                while (nodo_actual.getSiguiente() != null) {
                    if (nodo_actual.getSiguiente().getEstudiante().getDni() == clave) {
                        nodo_actual.cargarSiguiente(nodo_actual.getSiguiente().getSiguiente());
                        break;
                    }
                    nodo_actual = nodo_actual.getSiguiente();
                }
            }
        }
    }

    @Override
    public Estudiante recuperar(int clave) {
        Nodo_Estudiante nodo_actual = this.primer_nodo;
        while (nodo_actual != null) {
            if (nodo_actual.getEstudiante().getDni() == clave) {
                return nodo_actual.getEstudiante();
            }
            nodo_actual = nodo_actual.getSiguiente();
        }
        return null; // Si no se encuentra el estudiante con la clave dada
    }
}
