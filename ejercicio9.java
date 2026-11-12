import java.util.*;

public class ejercicio9 {

    public static int[] ejercicio9(int[] nums) {
        // Arreglo de respuestas: del mismo tamaño que nums, todo en 0 al empezar
        int[] counts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {      // número que estoy analizando
            for (int j = 0; j < i; j++) {            // los que están a su izquierda
                if (nums[j] > nums[i]) {             // ¿es mayor?
                    counts[i]++;                     // sí: sumo 1
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ejercicio9(new int[]{5, 3, 7, 1})));  // [0, 1, 0, 3]
        System.out.println(Arrays.toString(ejercicio9(new int[]{3, 2, 1})));     // [0, 1, 2]
        System.out.println(Arrays.toString(ejercicio9(new int[]{4, 4, 4})));     // [0, 0, 0]
    }
}