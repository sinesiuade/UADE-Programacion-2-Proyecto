import modelos.SistemaDeMatricula;
import modelos.consola.Consola;

public class Main {
    public static void main(String[] args) {
        try {
            SistemaDeMatricula sistema = new SistemaDeMatricula();

            sistema.ejecutar();
        } catch (NullPointerException e) {
            System.out.println(Consola.ROJO + "Referencia a Null");
            System.out.println("Detalle técnico: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Consola.ROJO + "Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(Consola.AMARILLO + "Se ha finalizado la ejecución del programa.");
        while (true) {

        }
    }
}
