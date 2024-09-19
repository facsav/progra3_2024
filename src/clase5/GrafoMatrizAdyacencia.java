package clase5;

import java.util.ArrayList;
import java.util.List;
//Actividad 2
public class GrafoMatrizAdyacencia {

    private int[][] matriz;  // Matriz de adyacencia
    private int numVertices; // Número de vértices

    // Constructor: inicializa la matriz de adyacencia
    public GrafoMatrizAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices]; // Matriz numVertices x numVertices, inicializada en 0
    }

    // Método para agregar una arista de vértice 'origen' a 'destino'
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matriz[origen][destino] = 1;  // Marcamos la arista en la matriz (dirigido)
            System.out.println("Arista agregada de " + origen + " a " + destino);
        } else {
            System.out.println("Índices inválidos para vértices");
        }
    }

    // Método para eliminar una arista de vértice 'origen' a 'destino'
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matriz[origen][destino] = 0;  // Eliminamos la arista
            System.out.println("Arista eliminada de " + origen + " a " + destino);
        } else {
            System.out.println("Índices inválidos para vértices");
        }
    }

    // Método para verificar si existe una arista de 'origen' a 'destino'
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            return matriz[origen][destino] == 1;
        }
        return false;
    }

    // Método para listar los vértices adyacentes a un vértice dado
    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    adyacentes.add(i);  // Agregar el vértice que es adyacente
                }
            }
        } else {
            System.out.println("Vértice inválido");
        }
        return adyacentes;
    }

    // Método para contar el grado de salida (número de aristas que salen) de un vértice
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
        } else {
            System.out.println("Vértice inválido");
        }
        return gradoSalida;
    }

    // Método para contar el grado de entrada (número de aristas que entran) de un vértice
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
        } else {
            System.out.println("Vértice inválido");
        }
        return gradoEntrada;
    }

    // Método para imprimir la matriz de adyacencia
    public void imprimirMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método principal para probar las funcionalidades
    public static void main(String[] args) {
        // Inicializamos un grafo con 5 vértices
        GrafoMatrizAdyacencia grafo = new GrafoMatrizAdyacencia(5);

        // Agregamos algunas aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        // Imprimimos la matriz de adyacencia
        System.out.println("Matriz de adyacencia:");
        grafo.imprimirMatriz();

        // Verificamos si existe una arista entre dos vértices
        System.out.println("Existe arista de 0 a 1: " + grafo.verificarArista(0, 1));
        System.out.println("Existe arista de 1 a 4: " + grafo.verificarArista(1, 4));

        // Listamos los vértices adyacentes al vértice 0
        System.out.println("Vértices adyacentes a 0: " + grafo.listarAdyacentes(0));

        // Contamos el grado de salida y entrada del vértice 2
        System.out.println("Grado de salida de 2: " + grafo.contarGradoSalida(2));
        System.out.println("Grado de entrada de 2: " + grafo.contarGradoEntrada(2));

        // Eliminamos una arista y volvemos a imprimir la matriz
        grafo.eliminarArista(2, 3);
        System.out.println("Matriz de adyacencia después de eliminar la arista de 2 a 3:");
        grafo.imprimirMatriz();
    }
}
