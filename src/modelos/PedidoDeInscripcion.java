package modelos;

import modelos.Materia;
import modelos.usuario.Estudiante;

public class PedidoDeInscripcion {
    private Estudiante estudiante;
    private Materia materia;

    PedidoDeInscripcion(Estudiante estudiante, Materia materia) {
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void mostrarPedido() {
        System.out.println("Estudiante: " + estudiante.getNombre() + " - Materia: " + materia.getNombre());
    }

    public String to_String() {
        return "Estudiante: " + this.estudiante.to_StringUsuario() + " | Materia: " + materia.to_String();
    }
}
