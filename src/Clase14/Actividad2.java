package Clase14;

public class Actividad2 {

    // Tamaño del tablero
    private static final int SIZE = 6;

    public static void main(String[] args) {
        int[][] board = {
                {5, 0, 0, 0, 4, 6},
                {0, 0, 6, 0, 0, 0},
                {0, 6, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 5},
                {6, 4, 0, 0, 0, 0}
        };

        System.out.println("Tablero inicial:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\nSudoku resuelto:");
            printBoard(board);
        } else {
            System.out.println("\nNo existe solución para este Sudoku.");
        }
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 2;
        int startCol = col - col % 3;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
