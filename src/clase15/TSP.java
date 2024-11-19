package clase15;

import java.util.Arrays;

public class TSP {
    static int n = 15; // Número de ciudades
    static double[][] distancias; // Matriz de distancias entre ciudades

    public static void main(String[] args) {
        // Ejemplo: Generar una matriz de distancias aleatorias
        generarDistancias();
        System.out.println("Número de combinaciones posibles: " + factorial(n - 1));

        // Método heurístico: Vecino más cercano
        int[] ruta = vecinoMasCercano(0);
        System.out.println("Ruta estimada: " + Arrays.toString(ruta));
    }

    static void generarDistancias() {
        distancias = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) distancias[i][j] = Math.random() * 100 + 1; // Distancias aleatorias
            }
        }
    }

    static long factorial(int num) {
        return (num <= 1) ? 1 : num * factorial(num - 1);
    }

    static int[] vecinoMasCercano(int inicio) {
        boolean[] visitado = new boolean[n];
        int[] ruta = new int[n];
        int actual = inicio;

        visitado[actual] = true;
        ruta[0] = actual;

        for (int i = 1; i < n; i++) {
            int ciudadCercana = -1;
            double menorDistancia = Double.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && distancias[actual][j] < menorDistancia) {
                    ciudadCercana = j;
                    menorDistancia = distancias[actual][j];
                }
            }

            ruta[i] = ciudadCercana;
            visitado[ciudadCercana] = true;
            actual = ciudadCercana;
        }

        return ruta;
    }
}

