package modelos;

import modelos.consola.Consola;
import modelos.estructuras.DiccionarioDinamico;
import modelos.estructuras.ConjuntoEstaticoMateria;
import modelos.usuario.Admin;
import modelos.usuario.Estudiante;
import modelos.usuario.Usuario;

public class SistemaDeMatricula {
    private DiccionarioDinamico usuarios;
    private ConjuntoEstaticoMateria materias;
    private Consola consola;
    private boolean esta_corriendo;
    private Usuario usuario_actual;

    public SistemaDeMatricula() {
        Admin administrador = new Admin(001, "admin", "admin", "admin");
        Estudiante estudiante = new Estudiante(111, "Dante", "Sinesi", "dante");

        this.usuarios = new DiccionarioDinamico();
        this.usuarios.agregar(administrador.getDocumento(), administrador);
        this.usuarios.agregar(estudiante.getDocumento(), estudiante);

        this.materias = new ConjuntoEstaticoMateria();
        this.materias.inicializar();

        Materia materia_0 = new Materia("Cálculo", 10);
        Materia materia_1 = new Materia("Programación 1", 2);

        this.materias.agregar(materia_0);
        this.materias.agregar(materia_1);

        // La idea acá sería hacer una inicialización, con algúnas materias de ejemplo,
        // USUARIO ADMIN, y algún que otro estudiante.

        consola = new Consola();
        // esta variable es crucial para la supervivencia del main
        this.esta_corriendo = true;
    }

    public void ejecutar() {
        consola.printlnColor(Consola.VERDE, "Bienvenido al Sistema de Matricula");
        while (this.esta_corriendo) {
            if (this.usuario_actual == null) {
                usuarioSinLogear();
            } else {
                usuarioLogeado();
            }
        }
    }

    private void usuarioSinLogear() {
        this.consola.printlnColor(Consola.CYAN, "Inicie sesión a continuación");
        int documento_login = this.consola.inputInt("Ingrese su documento: ");
        String contraseña_login = this.consola.inputString("Ingrese su contraseña: ");

        Usuario usuario = usuarios.recuperar(documento_login);

        if (usuario == null || !usuario.getContrasena().equals(contraseña_login)) {
            this.consola.limpiar();
            this.consola.printlnColor(Consola.ROJO, "Documento o Contraseña incorrectos, intente denuevo.");
        } else {
            this.consola.limpiar();
            this.consola.printlnColor(Consola.CYAN, "Bienvenido " + usuario.getNombre());

            this.usuario_actual = usuario;
        }
    }

    private void usuarioLogeado() {
        if (this.usuario_actual instanceof Admin) {
            this.consola.println("Administrador, que desea hacer:");
            this.consola.println("0 - Registrar nuevo estudiante.");
            this.consola.println("1 - peto");
            this.consola.println("2 - pito");
            this.consola.println("3 - poto");
            this.consola.println("4 - Salir.");
            int elección = this.consola.inputInt("Elección: ");
            switch (elección) {
                case 0:
                    this.consola.limpiar();
                    this.consola.printlnColor(Consola.CYAN, "Registrando nuevo estudiante");
                    int documento = this.consola.inputInt("Ingrese documento del estudiante: ");
                    String nombre = this.consola.inputString("Ingrese nombre del estudiante: ");
                    String apellido = this.consola.inputString("Ingrese apellido del estudiante: ");
                    String contraseña = this.consola.inputString("Ingrese contraseña del estudiante: ");
                    Estudiante estudiante = new Estudiante(documento, nombre, apellido, contraseña);
                    this.usuarios.agregar(estudiante.getDocumento(), estudiante);
                    this.consola.limpiar();
                    this.consola.printlnColor(Consola.VERDE, "Estudiante registrado con éxito.");
                    break;

                case 4:
                    this.consola.limpiar();
                    this.usuario_actual = null;
                    this.consola.printlnColor(Consola.VERDE, "Sesión cerrada con éxito.");
                    break;

                default:
                    this.consola.limpiar();
                    this.consola.printlnColor(Consola.ROJO, "No ha indicado una opción válida.");

                    break;
            }
        } else {
            this.consola.println("Estudiante, que desea hacer:");
            this.consola.println("0 - Ver materias disponibles.");
            this.consola.println("1 - Solicitar inscripción a materia.");
            this.consola.println("2 - pito");
            this.consola.println("3 - poto");
            this.consola.println("4 - Salir.");
            int elección = this.consola.inputInt("Elección: ");
            switch (elección) {
                case 0:
                    this.consola.limpiar();
                    this.consola.printlnColor(Consola.CYAN, "Materias disponibles:");

                    ConjuntoEstaticoMateria materias_aux = new ConjuntoEstaticoMateria();
                    materias_aux.inicializar();

                    while (!this.materias.estaVacio()) {
                        Materia m = this.materias.elegir();

                        this.consola.println("Nombre: " + m.getNombre() + " | Cupo: " + m.getCupo());

                        materias_aux.agregar(m);

                        materias.sacar(m);
                    }

                    while (!materias_aux.estaVacio()) {
                        Materia m = materias_aux.elegir();
                        materias.agregar(m);
                        materias_aux.sacar(m);
                    }

                    this.consola.println("");
                    break;

                case 4:
                    this.consola.limpiar();
                    this.usuario_actual = null;
                    this.consola.printlnColor(Consola.VERDE, "Sesión cerrada con éxito.");
                    break;

                default:
                    this.consola.limpiar();
                    this.consola.printlnColor(Consola.ROJO, "No ha indicado una opción válida.");

                    break;
            }
        }
    }
}