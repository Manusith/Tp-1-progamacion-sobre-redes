import java.util.*;

public class ejercicio17 {

    public static int ejercicio17(int[] monedas, int monto) {
        if (monto < 0) return -1;

        // "Imposible" lo represento con un número más grande que cualquier respuesta real
        int imposible = monto + 1;

        // dp[m] = cantidad mínima de monedas para formar el monto m
        int[] dp = new int[monto + 1];
        Arrays.fill(dp, imposible);   // al principio, todo es "imposible"
        dp[0] = 0;                    // para formar 0 no hace falta ninguna moneda

        for (int m = 1; m <= monto; m++) {          // calculo cada monto, de a uno
            for (int moneda : monedas) {            // pruebo usar cada moneda como la última
                if (moneda > 0 && moneda <= m) {
                    // si uso esta moneda, me quedan (m - moneda) por formar
                    dp[m] = Math.min(dp[m], dp[m - moneda] + 1);
                }
            }
        }

        return dp[monto] > monto ? -1 : dp[monto];  // si sigue "imposible", devuelvo -1
    }

    public static void main(String[] args) {
        System.out.println(ejercicio17(new int[]{1, 5, 2}, 13));              // 4
        System.out.println(ejercicio17(new int[]{3}, 4));                     // -1
        System.out.println(ejercicio17(new int[]{1, 3, 4}, 6));               // 2 (3+3)
        System.out.println(ejercicio17(new int[]{2}, 0));                     // 0
        System.out.println(ejercicio17(new int[]{5, 10}, 3));                 // -1
        System.out.println(ejercicio17(new int[]{186, 419, 83, 408}, 6249));  // 20
    }
}