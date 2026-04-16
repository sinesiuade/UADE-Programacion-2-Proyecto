package modelos.usuario;

import modelos.Materia;

public class Estudiante extends Usuario {

    private Materia[] materiasalumno = new Materia[10];
    private int cant = 0;

    public void InscribirseMateria(Materia materia) { // Permite inscribirse a materias
        if (cant < materiasalumno.length) {
            materiasalumno[cant] = materia;
            cant++;
        }
    }

    public Materia[] GetMateriasInscriptas() { // devuelve todas las materias inscriptas

        return materiasalumno;

    }

    public void EliminarMateriaInscripta(Materia materia) { // Elimina de materiasalumno la materia que se envio como
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