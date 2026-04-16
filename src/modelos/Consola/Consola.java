package modelos.consola;

import java.util.Scanner;

public class Consola {

    private static final Scanner scanner = new Scanner(System.in);

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
    public static void println(String texto) {
        System.out.println(RESET + texto);
    }

    public static void print(String texto) {
        System.out.print(RESET + texto);
    }

    // Escribir con color
    public static void printlnColor(String color, String texto) {
        System.out.println(color + texto + RESET);
    }

    public static void printColor(String color, String texto) {
        System.out.print(color + texto + RESET);
    }

    // Input
    public static String inputString(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextLine();
    }

    /**
     * Lee un número entero. Incluye manejo de errores básico para evitar que el
     * programa explote.
     */
    public static int inputInt(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + " ");
                String entrada = scanner.nextLine(); // Leemos como texto
                return Integer.parseInt(entrada); // Intentamos convertir a número
            } catch (NumberFormatException e) {
                printlnColor(ROJO, "Error: Por favor, ingrese un número válido.");
            }
        }
    }

    /**
     * Muestra un mensaje y espera a que el usuario presione Enter para continuar.
     */
    public static void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}