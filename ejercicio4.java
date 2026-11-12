    import java.util.*;

public class ejercicio4 {

    public static int[] ejercicio4(int[][] m, int target) {
        for (int fila = 0; fila < m.length; fila++) {            // recorro las filas
            for (int col = 0; col < m[fila].length; col++) {     // recorro las columnas
                if (m[fila][col] == target) {                    // ¿es el número que busco?
                    return new int[]{fila, col};                 // sí: devuelvo su posición
                }
            }
        }
        return new int[]{-1, -1};                                // miré todo y no estaba
    }

    public static void main(String[] args) {
        int[][] m = {{4, 5, 6}, {1, 2, 3}, {7, 8, 9}};
        System.out.println(Arrays.toString(ejercicio4(m, 5)));   // [0, 1]
        System.out.println(Arrays.toString(ejercicio4(m, 10)));  // [-1, -1]

        // Una matriz rotada de verdad (3 veces):
        int[][] r = {{4, 5, 6}, {7, 8, 9}, {1, 2, 3}};
        System.out.println(Arrays.toString(ejercicio4(r, 2)));   // [2, 1]
    }
}

