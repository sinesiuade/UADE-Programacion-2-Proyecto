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
        Usuario administrador = new Usuario(123, "admin", "admin", "admin");
        this.usuarios = new NodoDiccionario(administrador);

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
    }

    private void usuarioSinLogear() {
        int documento_login = this.consola.inputInt("Ingrese su usuario: ");
        String contraseña_login = this.consola.inputString("Ingrese su contraseña: ");

        Usuario usuario = buscarYValidarUsuario(documento_login, contraseña_login);

        if (usuario == null) {
            this.consola.println("Documento o Contraseña incorrectos, intente denuevo.");
        } else {
            this.consola.println("Bienvenido " + usuario.getNombre());
            this.usuario_actual = usuario;
        }
    }

    private void usuarioLogeado() {
        this.consola.println("ya esta logeado");
    }

    private Usuario buscarYValidarUsuario(int documento, String contrasenia) {
        NodoDiccionario actual = this.usuarios;

        while (actual != null) {
            Usuario u = actual.getUsuario();

            if (u != null) {
                if (u.getDocumento() == documento && u.getContrasena().equals(contrasenia)) {
                    return u;
                }
            }

            actual = actual.getSiguiente();
        }

        return null;
    }
}
