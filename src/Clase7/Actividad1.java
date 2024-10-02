package Clase7;

public class Actividad1 {

    final static int INF = 99999;

    public void floydWarshall(int[][] graph, int numNodos) {
        int[][] dist = new int[numNodos][numNodos];

        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < numNodos; k++) {
            for (int i = 0; i < numNodos; i++) {
                for (int j = 0; j < numNodos; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, numNodos);
    }

    public void printSolution(int[][] dist, int numNodos) {
        System.out.println("Matriz de distancias más cortas:");
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numNodos = 4;
        int[][] graph = {
                {0, 2, INF, 5},
                {INF, 0, INF, 4},
                {INF, INF, 0, INF},
                {INF, INF, 2, 0}
        };

        Actividad1 fw = new Actividad1();
        fw.floydWarshall(graph, numNodos);
    }
}

