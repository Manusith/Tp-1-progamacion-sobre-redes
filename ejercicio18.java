import java.util.*;

public class ejercicio18 {

    public static int[] ejercicio18(int[] d) {
        int[] r = d.clone();                       // trabajo sobre una copia

        for (int i = r.length - 1; i >= 0; i--) {  // de derecha a izquierda
            if (r[i] < 9) {                        // si no es 9, le sumo 1 y terminé
                r[i]++;
                return r;
            }
            r[i] = 0;                              // si es 9, pasa a 0 y "me llevo 1"
        }

        // Si llegué acá, eran todos 9 (por ejemplo {9,9}) y ahora son todos 0 ({0,0}).
        // Hace falta un dígito más al principio: {1,0,0}
        int[] resultado = new int[r.length + 1];   // arranca todo en 0
        resultado[0] = 1;
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ejercicio18(new int[]{1, 2, 3})));     // [1, 2, 4]
        System.out.println(Arrays.toString(ejercicio18(new int[]{9})));           // [1, 0]
        System.out.println(Arrays.toString(ejercicio18(new int[]{1, 9})));        // [2, 0]
        System.out.println(Arrays.toString(ejercicio18(new int[]{9, 9, 9})));     // [1, 0, 0, 0]
        System.out.println(Arrays.toString(ejercicio18(new int[]{0})));           // [1]
    }
}