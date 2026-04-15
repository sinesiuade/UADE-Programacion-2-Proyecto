import modelos.*;
import modelos.estructuras.O_ColaPrioridad_doble_arr;
import modelos.estructuras.O_ColaPrioridad_obj;
import modelos.estructuras.O_ColaPedidos_arr;

public class Main {
    public static void main(String[] args) {
        O_ColaPrioridad_doble_arr cola1 = new O_ColaPrioridad_doble_arr();
        O_ColaPrioridad_obj cola2 = new O_ColaPrioridad_obj();

        cola1.inicializar();
        cola2.inicializar();

        for (int i = 0; i < 10; i++) {
            int valor = (int) (Math.random() * 100);
            int prioridad = (int) (Math.random() * 10);
            System.out.println("Encolando valor: " + valor + " con prioridad: " + prioridad);
            cola1.encolar(valor, prioridad);
            cola2.encolar(valor, prioridad);
        }

        System.out.println("\nDesencolando elementos de la cola1:");
        while (!cola1.estaVacia()) {
            System.out.println("Valor: " + cola1.primero() + " Prioridad: " + cola1.prioridadPrimero());
            cola1.desencolar();
        }
        // pepe2
        System.out.println("\nDesencolando elementos de la cola2:");
        while (!cola2.estaVacia()) {
            System.out.println("Valor: " + cola2.primero() + " Prioridad: " + cola2.prioridadPrimero());
            cola2.desencolar();
        }
        // pepe

        // --- Demo cola pedidos ---
        System.out.println("\n--- Cola de Pedidos de Inscripcion ---");
        O_ColaPedidos_arr colaPedidos = new O_ColaPedidos_arr();
        colaPedidos.inicializar();

        Estudiante juan = new Estudiante();
        juan.setDni(111);
        juan.setNombre("Juan");

        Estudiante ana = new Estudiante();
        ana.setDni(222);
        ana.setNombre("Ana");

        Materia progra2 = new Materia();
        progra2.setNombre("Programacion 2");
        progra2.setCupo(1);

        Pedido pedido1 = new Pedido();
        pedido1.setEstudiante(juan);
        pedido1.setMateria(progra2);

        Pedido pedido2 = new Pedido();
        pedido2.setEstudiante(ana);
        pedido2.setMateria(progra2);

        colaPedidos.encolar(pedido1);
        colaPedidos.encolar(pedido2);

        System.out.println("Procesando pedidos FIFO:");
        while (!colaPedidos.estaVacia()) {
            Pedido pedidoActual = colaPedidos.primero();
            pedidoActual.mostrarPedido();
            Materia materia = pedidoActual.getMateria();
            if (materia.getCupo() > 0) {
                pedidoActual.getEstudiante().agregarMateria(materia);
                materia.setCupo(materia.getCupo() - 1);
                System.out.println("  -> Inscripcion aceptada");
            } else {
                System.out.println("  -> Sin cupo, inscripcion rechazada");
            }
            colaPedidos.desencolar();
        }
    }
}
