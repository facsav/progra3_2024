package clase5;
import java.util.*;

// Clase que representa una arista en el grafo
class Arista implements Comparable<Arista> {
    int origen, destino, peso;

    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.peso - otra.peso;  // Ordenar por peso
    }
}

// Clase que representa el Grafo
class Grafo {
    int numVertices;
    List<List<Arista>> listaAdyacencia;  // Lista de adyacencia

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>(numVertices);

        // Inicializar la lista de adyacencia
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Método para agregar una arista (bidireccional, por ser una red)
    public void agregarArista(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(origen, destino, peso));
        listaAdyacencia.get(destino).add(new Arista(destino, origen, peso));  // Grafo no dirigido
    }

    // Aplicar el algoritmo de Prim para encontrar el Árbol de Recubrimiento Mínimo
    public void primMST() {
        boolean[] enMST = new boolean[numVertices];  // Seguimiento de los nodos que ya están en el MST
        PriorityQueue<Arista> pq = new PriorityQueue<>();  // Cola de prioridad para las aristas
        List<Arista> mstAristas = new ArrayList<>();  // Lista para almacenar el MST
        int costoTotal = 0;  // Almacenar el costo total del MST

        // Comenzamos desde el vértice 0 (puedes cambiar el punto de inicio)
        enMST[0] = true;

        // Agregar todas las aristas desde el vértice 0 a la cola de prioridad
        pq.addAll(listaAdyacencia.get(0));

        // Mientras no se haya añadido a todos los vértices al MST
        while (!pq.isEmpty() && mstAristas.size() < numVertices - 1) {
            // Obtener la arista de menor peso
            Arista arista = pq.poll();

            // Si el destino de la arista ya está en el MST, ignorarla
            if (enMST[arista.destino]) {
                continue;
            }

            // Agregar la arista al MST
            mstAristas.add(arista);
            costoTotal += arista.peso;
            enMST[arista.destino] = true;  // Marcar el vértice como añadido al MST

            // Agregar todas las aristas desde el nuevo vértice al MST
            for (Arista adyacente : listaAdyacencia.get(arista.destino)) {
                if (!enMST[adyacente.destino]) {
                    pq.add(adyacente);
                }
            }
        }

        // Imprimir el MST y el costo total
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (Arista arista : mstAristas) {
            System.out.println("Estación " + arista.origen + " - Estación " + arista.destino + " : Costo " + arista.peso);
        }
        System.out.println("Costo total: " + costoTotal);
    }
}

public class RedDistribucionElectrica {
    public static void main(String[] args) {
        // Ejemplo con 5 estaciones
        Grafo grafo = new Grafo(5);

        // Agregar aristas (estaciones conectadas con sus costos)
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 20);
        grafo.agregarArista(1, 2, 30);
        grafo.agregarArista(1, 3, 5);
        grafo.agregarArista(2, 3, 15);
        grafo.agregarArista(3, 4, 8);
        grafo.agregarArista(2, 4, 6);

        // Aplicar el algoritmo de Prim para encontrar el MST
        grafo.primMST();
    }
}

