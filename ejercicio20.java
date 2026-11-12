
public class ejercicio20 {

    // ¿La letra es vocal? (convierte a minúscula para que 'A' también cuente)
    private static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int ejercicio20(String s, int k) {
        int max = 0; // la mejor cantidad encontrada hasta ahora

        // 'inicio' es la posición donde empieza cada subcadena
        for (int inicio = 0; inicio + k <= s.length(); inicio++) {

            int cantidad = 0; // vocales de esta subcadena

            for (int i = inicio; i < inicio + k; i++) {
                if (esVocal(s.charAt(i))) {
                    cantidad++;
                }
            }

            if (cantidad > max) {
                max = cantidad;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(ejercicio20("abcuuudef", 2));  // 2
        System.out.println(ejercicio20("abcuuudef", 3));  // 3
        System.out.println(ejercicio20("abcuuudef", 5));  // 4
        System.out.println(ejercicio20("xyz", 2));        // 0
        System.out.println(ejercicio20("ab", 5));         // 0
    }
}