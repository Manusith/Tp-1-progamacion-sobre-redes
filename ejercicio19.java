import java.util.*;

public class ejercicio19 {

    public static int ejercicio19(int[] a) {
        if (a.length == 0) return 0;

        int[] copia = a.clone();     // trabajo sobre una COPIA: el original no se toca
        Arrays.sort(copia);          // ordeno la copia de menor a mayor

        int max = 1;                 // la mejor secuencia encontrada hasta ahora
        int actual = 1;              // largo de la secuencia que estoy armando

        for (int i = 1; i < copia.length; i++) {
            if (copia[i] == copia[i - 1]) {
                continue;                          // repetido: no suma ni corta la secuencia
            }
            if (copia[i] == copia[i - 1] + 1) {
                actual++;                          // es el siguiente número: la secuencia crece
            } else {
                actual = 1;                        // hay un salto: empiezo una secuencia nueva
            }
            max = Math.max(max, actual);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10, 4, 20, 1, 3, 2};
        System.out.println(ejercicio19(a));                              // 4
        System.out.println(Arrays.toString(a));                          // [10, 4, 20, 1, 3, 2] (sin cambios)
        System.out.println(ejercicio19(new int[]{0, 3, 7, 1, 8, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(ejercicio19(new int[]{5}));                   // 1
        System.out.println(ejercicio19(new int[]{}));                    // 0
        System.out.println(ejercicio19(new int[]{7, 7, 7}));             // 1
    }
}