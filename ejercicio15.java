import java.util.*;

public class ejercicio15 {

    // Saca los ceros que sobran a la izquierda: {0,9,9} -> {9,9}
    private static int[] quitarCerosIzquierda(int[] d) {
        int i = 0;
        while (i < d.length - 1 && d[i] == 0) i++;
        return Arrays.copyOfRange(d, i, d.length);
    }

    public static int[] ejercicio15(int[] d) {
        int[] r = d.clone();          // trabajo sobre una copia
        int i = r.length - 1;         // empiezo por el dígito de más a la derecha

        // Mientras el dígito sea 0, no puedo restarle 1: "pido prestado"
        // al de la izquierda, y este 0 se convierte en 9.
        while (i >= 0 && r[i] == 0) {
            r[i] = 9;
            i--;
        }

        if (i < 0) {                  // eran todos ceros: no hay de dónde pedir prestado
            throw new IllegalArgumentException("No se puede restar 1 a 0");
        }

        r[i]--;                       // al primer dígito que no es 0 le resto 1
        return quitarCerosIzquierda(r);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ejercicio15(new int[]{1, 0, 0})));    // [9, 9]
        System.out.println(Arrays.toString(ejercicio15(new int[]{1, 2, 3})));    // [1, 2, 2]
        System.out.println(Arrays.toString(ejercicio15(new int[]{2, 0, 0})));    // [1, 9, 9]
        System.out.println(Arrays.toString(ejercicio15(new int[]{1, 0})));       // [9]
        System.out.println(Arrays.toString(ejercicio15(new int[]{1})));          // [0]
    }
}