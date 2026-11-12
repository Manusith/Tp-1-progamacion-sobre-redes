import java.util.*;
public class ejercicio12 {

    public static boolean ejercicio12(int[][] m, int target) {
        if (m == null || m.length == 0 || m[0].length == 0) return false;

        int fila = 0;                   // empiezo arriba...
        int col = m[0].length - 1;      // ...a la derecha (esquina superior derecha)

        while (fila < m.length && col >= 0) {   // mientras no me salga de la matriz
            int actual = m[fila][col];

            if (actual == target) {
                return true;            // lo encontré
            } else if (target > actual) {
                col--;                  // el target es más grande: voy a la izquierda
            } else {
                fila++;                 // el target es más chico: bajo una fila
            }
        }
        return false;                   // me salí de la matriz: no estaba
    }

    public static void main(String[] args) {
        int[][] m = {{10, 8, 6}, {7, 5, 3}, {1, 0, -1}};
        System.out.println(ejercicio12(m, 5));    // true
        System.out.println(ejercicio12(m, 6));    // true
        System.out.println(ejercicio12(m, 10));   // true
        System.out.println(ejercicio12(m, -1));   // true
        System.out.println(ejercicio12(m, 4));    // false
        System.out.println(ejercicio12(m, 11));   // false
    }
}