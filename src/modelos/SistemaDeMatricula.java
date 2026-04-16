package modelos;

public class SistemaDeMatricula {
    private boolean esta_corriendo = false;

    public void SistemaDeMatricula() {
        // La idea acá sería hacer una inicialización, con algúnas materias de ejemplo,
        // USUARIO ADMIN, y algún que otro estudiante.

        // esta variable es crucial para la supervivencia del main
        this.esta_corriendo = true;
    }

    public void ejecutar() {
        while (this.esta_corriendo) {
            // acá va lo que sería la estructura del sistema
        }
    }
}
