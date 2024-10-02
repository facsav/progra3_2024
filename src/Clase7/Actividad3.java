package Clase7;

import java.util.Scanner;
//Actividad 3
public class Actividad3 {

    final static int INF = 99999;


    public void floydWarshall(int[][] graph, int numCentros) {
        int[][] dist = new int[numCentros][numCentros];
        int[][] next = new int[numCentros][numCentros];


        for (int i = 0; i < numCentros; i++) {
            for (int j = 0; j < numCentros; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }


        for (int k = 0; k < numCentros; k++) {
            for (int i = 0; i < numCentros; i++) {
                for (int j = 0; j < numCentros; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }


        for (int i = 0; i < numCentros; i++) {
            if (dist[i][i] < 0) {
                System.out.println("El sistema de rutas contiene un ciclo negativo.");
                return;
            }
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el origen (índice entre 0 y " + (numCentros - 1) + "):");
        int origen = scanner.nextInt();
        System.out.println("Ingrese el destino (índice entre 0 y " + (numCentros - 1) + "):");
        int destino = scanner.nextInt();


        if (dist[origen][destino] == INF) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
        } else {
            System.out.println("El tiempo mínimo de entrega entre " + origen + " y " + destino + " es: " + dist[origen][destino] + " minutos.");
            System.out.print("El camino más corto es: ");
            imprimirCamino(origen, destino, next);
            System.out.println();
        }
    }


    public void imprimirCamino(int origen, int destino, int[][] next) {
        if (next[origen][destino] == -1) {
            System.out.print("No existe camino");
            return;
        }
        System.out.print(origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese el número de centros de distribución:");
        int numCentros = scanner.nextInt();


        int[][] graph = new int[numCentros][numCentros];

        System.out.println("Ingrese la matriz de tiempos (use " + INF + " para indicar que no hay ruta directa):");
        for (int i = 0; i < numCentros; i++) {
            for (int j = 0; j < numCentros; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }


        Actividad3 fw = new Actividad3();
        fw.floydWarshall(graph, numCentros);
    }
}
