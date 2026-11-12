import java.util.*;

public class ejercicio3 {

    // Saca los ceros que sobran a la izquierda: {0,3,6,9} -> {3,6,9}
    private static int[] quitarCerosIzquierda(int[] d) {
        int i = 0;
        while (i < d.length - 1 && d[i] == 0) i++;
        return Arrays.copyOfRange(d, i, d.length);
    }

    public static int[] ejercicio3(int[] d, int k) {
        if (k < 1 || k > 9) throw new IllegalArgumentException("K debe estar entre 1 y 9");

        // El resultado puede tener un dígito más (como 99 x 2 = 198),
        // así que dejo un lugar extra al principio.
        int[] res = new int[d.length + 1];
        int carry = 0; // el "me llevo"

        for (int i = d.length - 1; i >= 0; i--) {   // de derecha a izquierda
            int p = d[i] * k + carry;               // multiplico y sumo lo que me llevaba
            res[i + 1] = p % 10;                    // guardo el último dígito
            carry = p / 10;                         // me llevo el resto
        }
        res[0] = carry;                             // si sobró acarreo, va primero

        return quitarCerosIzquierda(res);
    }

    public static void main(String[] args) {
        // Ejemplos de la consigna
        System.out.println(Arrays.toString(ejercicio3(new int[]{1, 2, 3}, 3))); // [3, 6, 9]
        System.out.println(Arrays.toString(ejercicio3(new int[]{9, 9}, 2)));    // [1, 9, 8]
    }
}