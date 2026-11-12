 import java.util.*;
 
 public class ejercicio5 {

    // ¿La letra es vocal? (convierte a minúscula para que 'A' también cuente)
    private static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Consonante = es una letra y no es vocal
    private static boolean esConsonante(char c) {
        return Character.isLetter(c) && !esVocal(c);
    }

    public static int ejercicio5(String s, int k) {
        int max = 0; // la mejor cantidad encontrada hasta ahora

        // 'inicio' es la posición donde empieza cada pedazo
        for (int inicio = 0; inicio + k <= s.length(); inicio++) {

            int cantidad = 0; // consonantes de este pedazo

            // recorro las k letras del pedazo
            for (int i = inicio; i < inicio + k; i++) {
                if (esConsonante(s.charAt(i))) {
                    cantidad++;
                }
            }

            if (cantidad > max) {
                max = cantidad; // encontré un pedazo mejor
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(ejercicio5("abcuuudef", 3)); // 2
        System.out.println(ejercicio5("abcuuudef", 9)); // 4 (b, c, d, f)
    }
}