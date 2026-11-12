
public class ejercicio16 {

    public static int ejercicio16(String s, int k, int target) {
        // Recorro todas las posiciones donde puede empezar una ventana de largo k
        for (int inicio = 0; inicio + k <= s.length(); inicio++) {

            int suma = 0; // suma de los dígitos de esta ventana

            for (int i = inicio; i < inicio + k; i++) {
                suma += s.charAt(i) - '0';   // convierto el carácter '4' en el número 4 y lo sumo
            }

            if (suma == target) {
                return inicio;               // encontré la ventana: devuelvo dónde empieza
            }
        }
        return -1;                           // probé todas y ninguna sumaba target
    }

    public static void main(String[] args) {
        System.out.println(ejercicio16("123456", 3, 12));   // 2  ("345" suma 12)
        System.out.println(ejercicio16("123456", 3, 15));   // 3  ("456" suma 15)
        System.out.println(ejercicio16("123456", 3, 100));  // -1
        System.out.println(ejercicio16("12", 5, 3));        // -1
        System.out.println(ejercicio16("9182", 2, 9));      // 1  ("18" suma 9)
    }
}