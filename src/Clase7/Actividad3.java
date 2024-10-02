package Clase7;
import java.util.Scanner;

public class Actividad3 {
    final static int INF = 99999;

    public static void main(String[] args) {
        Actividad3 fw = new Actividad3();

        int graph[][] = {
                {0, 3, INF, 7},  // Centro 1
                {8, 0, 2, INF},  // Centro 2
                {5, INF, 0, 1},  // Centro 3
                {2, INF, INF, 0}  // Centro 4
        };

        int V = graph.length;

        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];
        fw.floydWarshall(graph, dist, next, V);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vértice de origen (0 a " + (V-1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el vértice de destino (0 a " + (V-1) + "): ");
        int destino = scanner.nextInt();

        fw.printPath(origen, destino, next);
        scanner.close();
    }

    void floydWarshall(int graph[][], int dist[][], int next[][], int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    void printPath(int origen, int destino, int next[][]) {
        if (next[origen][destino] == -1) {
            System.out.println("No existe un camino entre " + origen + " y " + destino);
            return;
        }

        System.out.print("El camino más corto entre " + origen + " y " + destino + " es: ");
        System.out.print(origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
    }
}
