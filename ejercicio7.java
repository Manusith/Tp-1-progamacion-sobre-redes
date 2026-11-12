import java.util.*;
public class ejercicio7 {

    // Devuelve true solo si la posición existe dentro del cubo Y hay un barco ahí
    private static boolean hayBarco(boolean[][][] cubo, int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0
                && x < cubo.length && y < cubo[0].length && z < cubo[0][0].length
                && cubo[x][y][z];
    }

    public static int ejercicio7(boolean[][][] cubo) {
        // Las 3 direcciones en las que puede estar acostado un submarino: X, Y o Z
        int[][] direcciones = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int submarinos = 0;

        for (int x = 0; x < cubo.length; x++) {
            for (int y = 0; y < cubo[0].length; y++) {
                for (int z = 0; z < cubo[0][0].length; z++) {

                    if (!cubo[x][y][z]) continue;            // celda de agua: la salteo

                    for (int[] d : direcciones) {
                        // Si la celda anterior (en esa dirección) también es barco,
                        // esta celda no es el comienzo: ya se contó desde antes.
                        if (hayBarco(cubo, x - d[0], y - d[1], z - d[2])) continue;

                        // Cuento cuántas celdas de barco seguidas hay desde acá
                        int largo = 0;
                        while (hayBarco(cubo, x + d[0] * largo, y + d[1] * largo, z + d[2] * largo)) {
                            largo++;
                        }

                        if (largo == 3) submarinos++;        // exactamente 3: es un submarino
                    }
                }
            }
        }
        return submarinos;
    }

    public static void main(String[] args) {
        boolean[][][] cubo = new boolean[3][3][3];   // todo empieza en false (agua)

        cubo[0][0][0] = true; cubo[0][0][1] = true; cubo[0][0][2] = true; // submarino en Z
        cubo[2][0][0] = true; cubo[2][1][0] = true; cubo[2][2][0] = true; // submarino en Y
        cubo[1][1][1] = true; cubo[1][1][2] = true;                       // barco de 2: NO cuenta

        System.out.println(ejercicio7(cubo)); // 2

        boolean[][][] otro = new boolean[4][4][4];
        for (int i = 0; i < 4; i++) otro[i][0][0] = true;   // barco de 4: NO cuenta
        System.out.println(ejercicio7(otro)); // 0

        boolean[][][] x3 = new boolean[3][3][3];
        for (int i = 0; i < 3; i++) x3[i][1][1] = true;     // submarino en X
        System.out.println(ejercicio7(x3));   // 1
    }
}