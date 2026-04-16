package modelos.usuario;

import modelos.Materia;

public class Estudiante extends Usuario {

    private Materia[] materiasalumno = new Materia[10];
    private int cant = 0;

    public Estudiante() {
        super();
    }

    public Estudiante(int documento, String nombre, String apellido, String contraseña) {
        super(documento, nombre, apellido, contraseña);
    }

    public void inscribirseMateria(Materia materia) { // Permite inscribirse a materias
        if (cant < materiasalumno.length) {
            materiasalumno[cant] = materia;
            cant++;
        }
    }

    public Materia[] getMateriasInscriptas() { // devuelve todas las materias inscriptas

        return materiasalumno;

    }

    public void eliminarMateriaInscripta(Materia materia) {
        int i = 0;

        //buscar
        while (i < cant && !materiasalumno[i].getNombre().equals(materia.getNombre())) {
            i++;
        }

        // eliminar si la encontro
        if (i < cant) {
            materiasalumno[i] = materiasalumno[cant - 1];
            materiasalumno[cant - 1] = null;
            cant--;
        }
    }
}