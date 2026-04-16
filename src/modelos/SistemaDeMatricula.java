package modelos;

import modelos.consola.Consola;
import modelos.estructuras.NodoDiccionario;
import modelos.usuario.Usuario;

public class SistemaDeMatricula {
    private NodoDiccionario usuarios;
    private Consola consola;
    private boolean esta_corriendo;
    private Usuario usuario_actual;

    public SistemaDeMatricula() {
        this.usuarios = new Usuario;
        // La idea acá sería hacer una inicialización, con algúnas materias de ejemplo,
        // USUARIO ADMIN, y algún que otro estudiante.

        consola = new Consola();
        // esta variable es crucial para la supervivencia del main
        this.esta_corriendo = true;
    }

    public void ejecutar() {
        consola.printlnColor(Consola.CYAN, "Bienvenido al Sistema de Matricula");
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
        String usuario_login = this.consola.inputString("Ingrese su usuario: ");
        String contraseña_login = this.consola.inputString("Ingrese su contraseña: ");
        if (validarUsuario(usuario_login, contraseña_login)) {

        }
    }

    private void usuarioLogeado() {

    }

    private boolean validarUsuario(String nombre, String contraseña) {
        // Verificamos que el arreglo no sea nulo
        if (this.usuarios == null)
            return false;

        for (Usuario u : this.usuarios) {
            // Importante: checkear que 'u' no sea null (por si el arreglo no está lleno)
            if (u != null) {
                // Comparamos nombre Y contraseña
                if (u.getNombre().equals(nombre) && u.getContrasena().equals(contraseña)) {
                    return true; // Encontrado y verificado
                }
            }
        }
        return false; // Si termina el bucle y no encontró nada
    }
}
