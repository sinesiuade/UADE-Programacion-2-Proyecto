package modelos.usuario;

import modelos.Materia;

public class Estudiante extends Usuario {

    private Materia[] materias_alumno = new Materia[10];
    private int cant_materias = 0;

    public Estudiante() {
        super();
    }

    public Estudiante(int documento, String nombre, String apellido, String contraseña) {
        super(documento, nombre, apellido, contraseña);
    }

    public void agregarMateria(Materia materia) { // Permite inscribirse a materias
        if (this.cant_materias < materias_alumno.length) {
            materias_alumno[this.cant_materias] = materia;
            this.cant_materias++;
        }
    }

    public int getCantMateriasInscriptas() {
        return this.cant_materias;
    }

    public Materia[] getMateriasInscriptas() { // devuelve todas las materias inscriptas
        return materias_alumno;
    }

    public boolean eliminarMateria(int idMateria) {
        int indiceEncontrado = -1;

        for (int i = 0; i < this.cant_materias; i++) {
            if (this.materias_alumno[i].getId() == idMateria) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado != -1) {
            this.materias_alumno[indiceEncontrado].sumarCupoDisponible();

            for (int i = indiceEncontrado; i < this.cant_materias - 1; i++) {
                this.materias_alumno[i] = this.materias_alumno[i + 1];
            }

            this.materias_alumno[this.cant_materias - 1] = null;
            this.cant_materias--;
            return true;
        }

        return false; // No se encontró la materia
    }

    public String to_String() {
        String materias = "[";

        int i = 0;
        for (Materia materia : materias_alumno) {
            if (i < this.cant_materias) {
                materias += materia.to_String();
                materias += ", ";
            } else {
                break;
            }
            i++;
        }
        materias += "]";

        return "DNI: " + documento + " | Nombre: " + nombre + " | Apellido: " + apellido + " | Materias Inscriptas ("
                + this.cant_materias + "): " + materias;
    }

    public String to_StringUsuario() {
        return super.to_String();
    }
}