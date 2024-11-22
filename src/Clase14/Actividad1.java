package Clase14;

public class Actividad1 {

    //CODIGO DEL REPO

    public class NQueens {

        // Tamaño del tablero
        private static final int N = 4;

        public static void main(String[] args) {
            int[][] board = new int[N][N];
            solve(board, 0);
            printBoard(board);
        }

        // Método de backtracking para resolver el problema
        public static boolean solve(int[][] board, int row) {
            if (row == N) { // Si todas las reinas están colocadas
                return true;
            }

            for (int col = 0; col < N; col++) {
                if (isSafe(board, row, col)) {
                    board[row][col] = 1;  // Coloca la reina

                    if (solve(board, row + 1)) {  // Recurre para colocar el resto
                        return true;
                    }

                    board[row][col] = 0;  // Si falla, descoloca la reina (backtracking)
                }
            }

            return false;  // No hay solución posible
        }

        // Verifica si es seguro colocar una reina en board[row][col]
        public static boolean isSafe(int[][] board, int row, int col) {
            // Verificar columna
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 1) {
                    return false;
                }
            }

            // Verificar diagonal superior izquierda
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            // Verificar diagonal superior derecha
            for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            return true;
        }

        // Método para imprimir el tablero
        public static void printBoard(int[][] board) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}

/*
1-
¿Cómo funciona el backtracking en este problema?
El backtracking intenta colocar una reina en cada columna de la fila actual. Si es seguro (según lo que dice isSafe), pasa a la siguiente fila. Si no puede avanzar, retrocede, quita la última reina y sigue probando.

2-
¿Qué pasa cuando el algoritmo encuentra una solución?
Cuando todas las reinas están en posiciones válidas (row == N), el algoritmo devuelve true y termina la búsqueda para imprimir el tablero.

3-
¿Qué ocurre cuando no puede colocar más reinas?
Si en una fila no hay ningún lugar seguro, retrocede a la fila anterior, borra la reina colocada y prueba en otra columna.

4-
¿Qué sucede en el código cuando el algoritmo "retrocede"?
Quita la última reina que puso con board[row][col] = 0 y sigue probando en otra columna de esa fila. En Python Tutor se ve cómo las llamadas en la pila "retroceden" y cambian las posiciones en el tablero.

5-
¿Cómo se visualiza en Python Tutor?
Ves cómo se colocan y quitan las reinas. Cuando retrocede, los cuadros del tablero vuelven a cero, y los marcos de la pila de llamadas se cierran hasta probar otra opción.

6-
¿Qué modificaciones harías para aumentar N a 8?
Solo cambiar N a 8 (private static final int N = 8;). El algoritmo ya está preparado para trabajar con cualquier tamaño de tablero.

7-
¿Cómo crees que cambiaría el tiempo de ejecución?
Al aumentar N, hay muchas más combinaciones posibles que probar. Con N = 8, el tiempo de ejecución crece mucho porque hay más caminos que explorar.

8-
¿Por qué el metodo isSafe es crucial en este algoritmo?
Porque sin isSafe, el algoritmo no sabe si una posición es válida. Es el que asegura que no haya conflictos entre las reinas y que el tablero tenga sentido.
 */