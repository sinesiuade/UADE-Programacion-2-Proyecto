package modelos.usuario;

import modelos.Materia;

public class Estudiante extends Usuario {

    private Materia[] materiasalumno = new Materia[10];
    private int cant = 0;

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

    public void eliminarMateriaInscripta(Materia materia) { // Elimina de materiasalumno la materia que se envio como
                                                            // parametro
        int i = 0;

        while (i < cant && materiasalumno[i] != materia) {
            i++;

            if (i < cant) {
                materiasalumno[i] = materiasalumno[cant - 1];
                cant--;
            }
        }
    }
}