public class ejercicio14 {

    // Devuelve true solo si la posición existe dentro del tablero Y hay un barco ahí
    private static boolean hayBarco(boolean[][] t, int fila, int col) {
        return fila >= 0 && col >= 0
                && fila < t.length && col < t[0].length
                && t[fila][col];
    }

    public static int ejercicio14(boolean[][] t) {
        // Las 2 direcciones diagonales: \ (baja a la derecha) y / (baja a la izquierda)
        int[][] direcciones = {{1, 1}, {1, -1}};
        int barcos = 0;

        for (int fila = 0; fila < t.length; fila++) {
            for (int col = 0; col < t[0].length; col++) {

                if (!t[fila][col]) continue;                 // agua: la salteo

                for (int[] d : direcciones) {
                    // Si la celda anterior (en esa diagonal) también es barco,
                    // esta celda no es el comienzo: ya se contó desde antes.
                    if (hayBarco(t, fila - d[0], col - d[1])) continue;

                    // Cuento cuántas celdas de barco seguidas hay desde acá
                    int largo = 0;
                    while (hayBarco(t, fila + d[0] * largo, col + d[1] * largo)) {
                        largo++;
                    }

                    if (largo >= 2) barcos++;                // largo 2 o más: es un barco diagonal
                }
            }
        }
        return barcos;
    }

    public static void main(String[] args) {
        // Ejemplo de la consigna: diagonal \ de 3 celdas
        boolean[][] t1 = new boolean[3][3];
        t1[0][0] = true; t1[1][1] = true; t1[2][2] = true;
        System.out.println(ejercicio14(t1));   // 1

        // Diagonal / de 3 celdas
        boolean[][] t2 = new boolean[3][3];
        t2[0][2] = true; t2[1][1] = true; t2[2][0] = true;
        System.out.println(ejercicio14(t2));   // 1

        // Una sola celda: NO cuenta (largo 1)
        boolean[][] t3 = new boolean[3][3];
        t3[1][1] = true;
        System.out.println(ejercicio14(t3));   // 0

        // Dos barcos separados, uno en cada diagonal
        boolean[][] t4 = new boolean[5][5];
        t4[3][0] = true; t4[4][1] = true;      // barco \ de 2
        t4[0][4] = true; t4[1][3] = true;      // barco / de 2
        System.out.println(ejercicio14(t4));   // 2
    }
}