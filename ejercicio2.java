import java.util.*;

public class ejercicio2 {

    public static int ejercicio2(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);

        int max = 0;
        for (int x : set) {
            if (set.contains(x - 1)) continue; 
            int largo = 1;
            while (set.contains(x + largo)) largo++;
            max = Math.max(max, largo);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(ejercicio2(new int[]{1, 2, 4, 5, 6, 7})); // 4
        System.out.println(ejercicio2(new int[]{2, 1}));             // 2
    }
}