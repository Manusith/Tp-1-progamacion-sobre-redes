import java.util.*;

public class ejercicio6 {

    public static int[] ejercicio6(int[] nums, int[][] rotaciones) {
        // Copia del arreglo original: acá voy a escribir los cambios
        int[] resultado = nums.clone();

        // Por cada rango [start, end]
        for (int[] r : rotaciones) {
            int start = r[0];
            int end = r[1];
            int largo = end - start + 1;

            for (int i = 0; i < largo; i++) {
                // El elemento en la posición (start + i) se mueve un lugar a la derecha.
                // El "% largo" hace que el último vuelva al principio del tramo.
                int destino = start + (i + 1) % largo;
                resultado[destino] = nums[start + i];   // leo del original
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        // Ejemplo de la consigna
        System.out.println(Arrays.toString(
                ejercicio6(new int[]{1, 2, 3, 4, 5}, new int[][]{{0, 1}, {2, 3}}))); // [2, 1, 4, 3, 5]

        // Un tramo de 3 elementos
        System.out.println(Arrays.toString(
                ejercicio6(new int[]{1, 2, 3, 4, 5}, new int[][]{{0, 2}})));         // [3, 1, 2, 4, 5]
    }
}