package modelos;

import modelos.consola.Consola;
import modelos.usuario.Usuario;

public class SistemaDeMatricula {
    private Consola consola;
    private boolean esta_corriendo;
    private Usuario usuario_actual;

    public void SistemaDeMatricula() {
        // La idea acá sería hacer una inicialización, con algúnas materias de ejemplo,
        // USUARIO ADMIN, y algún que otro estudiante.

        consola = new Consola();
        // esta variable es crucial para la supervivencia del main
        this.esta_corriendo = true;
    }

    public void ejecutar() {
        while (this.esta_corriendo) {
            if (this.usuario_actual == null) {
                usuarioSinLogear();
            } else {
                usuarioLogeado();
            }
        }
        System.out.println("Hola");
    }

    private void usuarioSinLogear() {
        this.consola.println(Consola.AMARILLO, "Bienvenido al Sistema de Matricula, por favor, ingrese su usuario: ");

    }

    private void usuarioLogeado() {

    }
}