package Clase7;

public class Actividad2 {
    final static int INF = 99999;

    public static void main(String[] args) {
        Actividad2 fw = new Actividad2();

        int graph[][] = {
                {0, 3, INF, 7},  // Centro 1
                {8, 0, 2, INF},  // Centro 2
                {5, INF, 0, 1},  // Centro 3
                {2, INF, INF, 0}  // Centro 4



                //Ejemplo para chequear si hay ciclos negativos
                /*
                {0, 1, INF, INF},  // Centro 1
                {INF, 0, -1, INF},  // Centro 2
                {INF, INF, 0, -1},  // Centro 3
                {-1, INF, INF, 0}   // Centro 4

                 */
        };

        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("El sistema contiene un ciclo negativo.");
                return;
            }
        }

        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
