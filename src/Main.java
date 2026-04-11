import modelos.*;
import modelos.estructuras.O_ColaPrioridad_doble_arr;
import modelos.estructuras.O_ColaPrioridad_obj;

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
    }
}
