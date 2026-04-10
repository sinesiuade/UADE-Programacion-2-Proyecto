package modelos.Consola;

public class Consola {

    // Reset
    public static final String RESET = "\033[0m";

    // Colores de texto
    public static final String NEGRO = "\033[30m";
    public static final String ROJO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AMARILLO = "\033[33m";
    public static final String AZUL = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String BLANCO = "\033[37m";

    // Limpiar pantalla
    public static void limpiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Escribir sin color
    public static void println(String color, String texto) {
        System.out.println(RESET + texto);
    }

    public static void print(String color, String texto) {
        System.out.print(RESET + texto);
    }

    // Escribir con color
    public static void printlnColor(String color, String texto) {
        System.out.println(color + texto + RESET);
    }

    public static void printColor(String color, String texto) {
        System.out.print(color + texto + RESET);
    }
}