import java.util.*;

public class ejercicio11 {

    public static int[] ejercicio11(int[] a, int[] b, int k) {
        if (k < 2 || k > 16) throw new IllegalArgumentException("K debe estar entre 2 y 16");
        if (a.length != b.length) throw new IllegalArgumentException("A y B deben tener la misma longitud");

        int n = a.length;
        int[] resultado = new int[n + 1]; // un lugar extra por si sobra acarreo
        int carry = 0;                    // el "me llevo"

        for (int i = n - 1; i >= 0; i--) {          // de derecha a izquierda
            int suma = a[i] + b[i] + carry;         // sumo los dos dígitos y lo que me llevaba
            resultado[i + 1] = suma % k;            // el dígito que me quedo
            carry = suma / k;                       // lo que me llevo
        }

        if (carry > 0) {            // sobró acarreo: va al principio
            resultado[0] = carry;
            return resultado;
        }
        return Arrays.copyOfRange(resultado, 1, n + 1);   // no sobró: saco el lugar extra
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ejercicio11(new int[]{1, 2}, new int[]{1, 8}, 10)));   // [3, 0]
        System.out.println(Arrays.toString(ejercicio11(new int[]{9, 9}, new int[]{9, 9}, 10)));   // [1, 9, 8]
        System.out.println(Arrays.toString(ejercicio11(new int[]{1, 1}, new int[]{1, 1}, 2)));    // [1, 1, 0]
        System.out.println(Arrays.toString(ejercicio11(new int[]{15, 15}, new int[]{0, 1}, 16))); // [1, 0, 0]
    }
}