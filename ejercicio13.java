public class ejercicio13 {

    // ¿El carácter '0'..'9' es un dígito par?
    private static boolean esPar(char c) {
        int digito = c - '0';       // convierte el carácter '7' en el número 7
        return digito % 2 == 0;     // par = se puede dividir por 2 sin resto (el 0 es par)
    }

    public static int ejercicio13(String s, int k) {
        int max = 0; // la mejor cantidad encontrada hasta ahora

        // 'inicio' es la posición donde empieza cada ventana
        for (int inicio = 0; inicio + k <= s.length(); inicio++) {

            int cantidad = 0; // pares de esta ventana

            for (int i = inicio; i < inicio + k; i++) {
                if (esPar(s.charAt(i))) {
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
        System.out.println(ejercicio13("1234567890", 3)); // 2
        System.out.println(ejercicio13("1357", 2));       // 0
        System.out.println(ejercicio13("2468", 4));       // 4
        System.out.println(ejercicio13("12", 5));         // 0
    }
}