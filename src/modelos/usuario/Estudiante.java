package modelos.usuario;

import interfaces.estructuras.I_ConjuntoEstaticoMateria;
import modelos.Materia;
import modelos.Utilidades;
import modelos.estructuras.ConjuntoEstaticoMateria;

public class Estudiante extends Usuario {

    private I_ConjuntoEstaticoMateria materias_alumno;
    private int cant_materias = 0;

    public Estudiante() {
        super();
    }

    public Estudiante(int documento, String nombre, String apellido, String contraseña) {
        super(documento, nombre, apellido, contraseña);

        this.materias_alumno = new ConjuntoEstaticoMateria();
        this.materias_alumno.inicializar();
    }

    public void agregarMateria(Materia materia) { // Permite inscribirse a materias
        this.materias_alumno.agregar(materia);
    }

    public int getCantMateriasInscriptas() {
        return this.cant_materias;
    }

    public I_ConjuntoEstaticoMateria getMateriasInscriptas() { // devuelve una copia de todas las materias inscriptas
        I_ConjuntoEstaticoMateria materias_temp = Utilidades.copiarConjunto(this.materias_alumno);
        return materias_temp;
    }

    public boolean eliminarMateria(int idMateria) {
        I_ConjuntoEstaticoMateria materias_temp = Utilidades.copiarConjunto(this.materias_alumno);

        Materia materia_encontrada = null;

        while (!materias_temp.estaVacio()) {
            Materia materia = materias_temp.elegir();
            if (materia.getId() == idMateria) {
                materia_encontrada = materia;
                break;
            }
            materias_temp.sacar(materia);
        }

        if (materia_encontrada != null) {
            materia_encontrada.sumarCupoDisponible();

            materias_alumno.sacar(materia_encontrada);
            return true;
        }
        return false;
    }

    public String to_String() {
        String materias = "[";

        I_ConjuntoEstaticoMateria materias_temp = Utilidades.copiarConjunto(this.materias_alumno);

        while (!materias_temp.estaVacio()) {
            Materia materia = materias_temp.elegir();
            materias += materia.to_String();
            materias += ", ";
        }
        materias += "]";

        return "DNI: " + documento + " | Nombre: " + nombre + " | Apellido: " + apellido + " | Materias Inscriptas ("
                + this.cant_materias + "): " + materias;
    }

    public String to_StringUsuario() {
        return super.to_String();
    }
}