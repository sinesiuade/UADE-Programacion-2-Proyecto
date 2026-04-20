package modelos;

import interfaces.estructuras.I_DiccionarioDinamico;
import interfaces.estructuras.I_ConjuntoEstaticoMateria;
import interfaces.estructuras.I_ColaPedidos;
import modelos.consola.Consola;
import modelos.estructuras.DiccionarioDinamico;
import modelos.estructuras.ConjuntoEstaticoMateria;
import modelos.estructuras.ColaPedidos;
import modelos.usuario.Admin;
import modelos.usuario.Estudiante;
import modelos.usuario.Usuario;

public class SistemaDeMatricula {
    private I_DiccionarioDinamico usuarios;
    private I_ConjuntoEstaticoMateria materias;
    private I_ColaPedidos pedidos_inscripcion;
    private Consola consola;
    private boolean esta_corriendo;
    private Usuario usuario_actual;

    public SistemaDeMatricula() {
        Admin administrador = new Admin(001, "admin", "admin", "admin");
        Estudiante estudiante_1 = new Estudiante(111, "Dante", "Sinesi", "dante");
        Estudiante estudiante_2 = new Estudiante(222, "Juani", "Ni Idea", "juani");

        this.usuarios = new DiccionarioDinamico();
        this.usuarios.agregar(administrador.getDocumento(), administrador);
        this.usuarios.agregar(estudiante_1.getDocumento(), estudiante_1);
        this.usuarios.agregar(estudiante_2.getDocumento(), estudiante_2);

        this.materias = new ConjuntoEstaticoMateria();
        this.materias.inicializar();

        Materia materia_0 = new Materia(0, "Cálculo", 10);
        Materia materia_1 = new Materia(1, "Programación 2", 1);

        this.materias.agregar(materia_0);
        this.materias.agregar(materia_1);

        this.pedidos_inscripcion = new ColaPedidos();
        this.pedidos_inscripcion.inicializar();

        this.consola = new Consola();
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
            this.consola.println("1 - Registrar nueva materia.");
            this.consola.println("2 - Ver Pedidos de Inscripción.");
            this.consola.println("3 - Procesar Pedidos de Inscripción.");
            this.consola.println("4 - Salir.");
            int elección = this.consola.inputInt("Elección: ");
            switch (elección) {
                case 0:
                    this.consola.limpiar();
                    adm_registra_estudiante();
                    break;

                case 1:
                    this.consola.limpiar();
                    adm_registra_materia();

                case 2:
                    this.consola.limpiar();
                    adm_lista_pedidos();
                    break;

                case 3:
                    this.consola.limpiar();
                    adm_procesar_pedidos();
                    break;

                case 4:
                    this.consola.limpiar();
                    usu_cierra_sesion();
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
            this.consola.println("2 - Ver solicitudes pendientes de aceptación.");
            this.consola.println("3 - Ver materias inscriptas.");
            this.consola.println("4 - Anular inscripcion a materia.");
            this.consola.println("5 - Salir.");
            int elección = this.consola.inputInt("Elección: ");
            switch (elección) {
                case 0:
                    this.consola.limpiar();
                    est_lista_materias();
                    break;

                case 1:
                    this.consola.limpiar();
                    est_solicitar_inscripcion();
                    break;

                case 2:
                    this.consola.limpiar();
                    est_ver_solicitudes_pendientes();
                    break;

                case 3:
                    this.consola.limpiar();
                    est_ver_materias_inscriptas();
                    break;

                case 4:
                    this.consola.limpiar();
                    est_anular_inscripcion();
                    break;

                case 5:
                    this.consola.limpiar();
                    usu_cierra_sesion();
                    break;

                default:
                    this.consola.limpiar();
                    this.consola.printlnColor(Consola.ROJO, "No ha indicado una opción válida.");
                    break;
            }
        }
    }

    private void usu_cierra_sesion() {
        this.usuario_actual = null;
        this.consola.printlnColor(Consola.VERDE, "Sesión cerrada con éxito.");
    }

    private void adm_registra_estudiante() {
        this.consola.printlnColor(Consola.CYAN, "Registrando nuevo estudiante");
        int documento = this.consola.inputInt("Ingrese documento del estudiante: ");
        String nombre = this.consola.inputString("Ingrese nombre del estudiante: ");
        String apellido = this.consola.inputString("Ingrese apellido del estudiante: ");
        String contraseña = this.consola.inputString("Ingrese contraseña del estudiante: ");
        Estudiante estudiante = new Estudiante(documento, nombre, apellido, contraseña);
        this.usuarios.agregar(estudiante.getDocumento(), estudiante);
        this.consola.limpiar();
        this.consola.printlnColor(Consola.VERDE, "Estudiante registrado con éxito.");
    }

    private void adm_registra_materia() {
        this.consola.printlnColor(Consola.CYAN, "Registrando nueva materia");
        String nombre = this.consola.inputString("Ingrese nombre de la materia: ");
        int cupo = this.consola.inputInt("Ingrese cupo de la materia: ");
        Materia materia = new Materia(proximo_id_materia_disponible(), nombre, cupo);
        this.materias.agregar(materia);
        this.consola.limpiar();
        this.consola.printlnColor(Consola.VERDE, "Materia registrada con éxito.");
    }

    private int proximo_id_materia_disponible() {
        int maxId = 0;
        I_ConjuntoEstaticoMateria materias_temp = copiarConjunto(this.materias);

        while (!materias_temp.estaVacio()) {
            Materia m = materias_temp.elegir();

            if (m.getId() > maxId) {
                maxId = m.getId();
            }

            materias_temp.sacar(m);
        }

        return maxId + 1;
    }

    private void adm_lista_pedidos() {
        this.consola.printlnColor(Consola.CYAN, "Solicitudes de Inscripción Pendientes:");
        I_ColaPedidos pedidos_temp = copiarCola(this.pedidos_inscripcion);

        int i = 0;

        while (!pedidos_temp.estaVacia()) {
            PedidoDeInscripcion p = pedidos_temp.primero();

            this.consola.println("Pedido [" + i + "]: {Estudiante: [Nombre: " + p.getEstudiante().getNombre()
                    + ", Documento: " + p.getEstudiante().getDocumento() + "}, {Materia: [ID: " + p.getMateria().getId()
                    + ", Nombre: " + p.getMateria().getNombre() + "]");

            pedidos_temp.desencolar();
            i++;
        }
        this.consola.println("");
    }

    private void adm_procesar_pedidos() {
        this.consola.printlnColor(Consola.CYAN, "Solicitudes de Inscripción Procesadas. Resultado:");
        int i = 0;
        while (!this.pedidos_inscripcion.estaVacia()) {
            PedidoDeInscripcion p = this.pedidos_inscripcion.primero();
            if (p.getMateria().tieneCupoDisponible()) {
                p.getEstudiante().agregarMateria(p.getMateria());
                p.getMateria().restarCupoDisponible();
                this.consola.printlnColor(Consola.VERDE, "Pedido [" + i + "]: ACEPTADO");
            } else {
                this.consola.printlnColor(Consola.ROJO, "Pedido [" + i + "]: RECHAZADO");
            }

            this.pedidos_inscripcion.desencolar();
            i++;
        }
    }

    private void est_lista_materias() {
        this.consola.printlnColor(Consola.CYAN, "Materias disponibles:");

        I_ConjuntoEstaticoMateria materias_temp = copiarConjunto(this.materias);

        while (!materias_temp.estaVacio()) {
            Materia m = materias_temp.elegir();

            this.consola.println(m.to_String());

            materias_temp.sacar(m);
        }

        this.consola.println("");
    }

    private void est_solicitar_inscripcion() {
        this.consola.printlnColor(Consola.CYAN, "Realizando Solicitud a Materias:");
        this.consola.println("");

        est_lista_materias();

        int id = this.consola.inputInt("Ingrese id de la materia a inscribir: ");

        Materia materia = null;
        I_ConjuntoEstaticoMateria materias_temp = copiarConjunto(this.materias);
        while (!materias_temp.estaVacio()) {
            Materia m = materias_temp.elegir();

            if (m.getId() == id) {
                materia = m;
                break;
            }

            materias_temp.sacar(m);
        }
        this.consola.limpiar();

        Usuario usuario = this.usuarios.recuperar(this.usuario_actual.getDocumento());

        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            if (materia == null) {
                this.consola.printlnColor(Consola.ROJO, "No se ha encontrado la materia indicada.");
            } else {
                PedidoDeInscripcion pedido = new PedidoDeInscripcion(estudiante, materia);

                this.pedidos_inscripcion.acolar(pedido);

                this.consola.printlnColor(Consola.VERDE, "Solicitud enviada con éxito.");
            }
        } else {
            this.consola.printlnColor(Consola.ROJO, "Error: El usuario actual no es un estudiante.");
        }
    }

    private void est_ver_solicitudes_pendientes() {
        this.consola.printlnColor(Consola.CYAN, "Solicitudes de Inscripción Pendientes:");
        I_ColaPedidos pedidos_temp = copiarCola(this.pedidos_inscripcion);
        while (!pedidos_temp.estaVacia()) {
            PedidoDeInscripcion p = pedidos_temp.primero();

            if (p.getEstudiante().getDocumento() == this.usuario_actual.getDocumento()) {
                this.consola.println(p.to_String());
            }

            pedidos_temp.desencolar();
        }
        this.consola.println("");
    }

    private void est_ver_materias_inscriptas() {
        this.consola.printlnColor(Consola.CYAN, "Materias Inscriptas:");

        Usuario usuario = this.usuarios.recuperar(this.usuario_actual.getDocumento());

        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            for (int i = 0; i < estudiante.getCantMateriasInscriptas(); i++) {
                this.consola.println(estudiante.getMateriasInscriptas()[i].to_String());
            }
        }
        this.consola.println("");
    }

    private void est_anular_inscripcion() {
        est_ver_materias_inscriptas();
        int idSeleccionado = this.consola.inputInt("Ingrese el ID de la materia para anular inscripción: ");
        Usuario usuario = this.usuarios.recuperar(this.usuario_actual.getDocumento());

        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;

            boolean exito = estudiante.eliminarMateria(idSeleccionado);

            this.consola.limpiar();
            if (exito) {
                this.consola.printlnColor(Consola.VERDE, "Inscripción anulada con éxito.");
            } else {
                this.consola.printlnColor(Consola.ROJO, "No estás inscripto en una materia con ese ID.");
            }
        }
    }

    private I_ConjuntoEstaticoMateria copiarConjunto(I_ConjuntoEstaticoMateria original) {
        I_ConjuntoEstaticoMateria copia = new ConjuntoEstaticoMateria();
        copia.inicializar();
        I_ConjuntoEstaticoMateria aux = new ConjuntoEstaticoMateria();
        aux.inicializar();

        while (!original.estaVacio()) {
            Materia m = original.elegir();
            aux.agregar(m);
            copia.agregar(m);
            original.sacar(m);
        }

        while (!aux.estaVacio()) {
            Materia m = aux.elegir();
            original.agregar(m);
            aux.sacar(m);
        }

        return copia;
    }

    private I_ColaPedidos copiarCola(I_ColaPedidos original) {
        I_ColaPedidos copia = new ColaPedidos();
        copia.inicializar();

        I_ColaPedidos aux = new ColaPedidos();
        aux.inicializar();

        while (!original.estaVacia()) {
            PedidoDeInscripcion p = original.primero();
            copia.acolar(p);
            aux.acolar(p);
            original.desencolar();
        }

        while (!aux.estaVacia()) {
            original.acolar(aux.primero());
            aux.desencolar();
        }

        return copia;
    }
}