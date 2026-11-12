import java.util.*;

public class TP1 {

    // ------------------------------------------------------------------
    // Utilidades comunes
    // ------------------------------------------------------------------

    /** Elimina ceros a la izquierda dejando al menos un dígito. */
    private static int[] quitarCerosIzquierda(int[] d) {
        int i = 0;
        while (i < d.length - 1 && d[i] == 0) i++;
        return Arrays.copyOfRange(d, i, d.length);
    }

    private static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean esConsonante(char c) {
        return Character.isLetter(c) && !esVocal(c);
    }

    public static boolean ejercicio1(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) return false;
        int top = 0, bottom = m.length - 1, left = 0, right = m[0].length - 1;
        int esperado = 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) if (m[top][j] != esperado++) return false;
            top++;
            for (int i = top; i <= bottom; i++) if (m[i][right] != esperado++) return false;
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) if (m[bottom][j] != esperado++) return false;
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) if (m[i][left] != esperado++) return false;
                left++;
            }
        }
        return true;
    }

    // Método main para poder ejecutar y probar
    public static void main(String[] args) {
        System.out.println(ejercicio1(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}})); // true
        System.out.println(ejercicio1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})); // false
    }

} // <-- esta es la llave que faltaba (cierra la clase)