import java.util.*;

public class ejercicio10 {

    public static int ejercicio10(int[] a) {
        int max = 0; // el pedazo más largo encontrado hasta ahora

        // Pruebo empezar el pedazo en cada posición del arreglo
        for (int inicio = 0; inicio < a.length; inicio++) {

            Set<Integer> usados = new HashSet<>(); // números que ya usé como pareja
            int largo = 0;                         // largo del pedazo actual
            int p = inicio;                        // posición donde miro ahora

            // Mientras haya una pareja de números iguales en p y p+1,
            // y ese número no lo haya usado antes...
            while (p + 1 < a.length && a[p] == a[p + 1] && !usados.contains(a[p])) {
                usados.add(a[p]);   // anoto el número como usado
                largo += 2;         // el pedazo creció en 2
                p += 2;             // salto a la siguiente pareja
            }

            max = Math.max(max, largo);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(ejercicio10(new int[]{1, 2, 2, 3, 3, 4, 1}));  // 4
        System.out.println(ejercicio10(new int[]{1, 1, 2, 2, 1, 1}));     // 4
        System.out.println(ejercicio10(new int[]{1, 1, 1, 1}));           // 2
        System.out.println(ejercicio10(new int[]{5, 6, 7}));              // 0
    }
}