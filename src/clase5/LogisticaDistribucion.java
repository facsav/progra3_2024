package clase5;
import java.util.*;

//Actividad 4
class Carretera {
    int destino, tiempo;

    public Carretera(int destino, int tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }
}

// Clase que representa la Red de Distribución (antes Grafo)
class RedDistribucion {
    int numCentros;  // Número de centros de distribución
    List<List<Carretera>> listaAdyacencia;  // Lista de adyacencia para almacenar el grafo

    // Constructor
    public RedDistribucion(int numCentros) {
        this.numCentros = numCentros;
        listaAdyacencia = new ArrayList<>(numCentros);

        // Inicializamos la lista de adyacencia
        for (int i = 0; i < numCentros; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Método para agregar una carretera entre dos centros con un tiempo de viaje asociado
    public void agregarCarretera(int origen, int destino, int tiempo) {
        listaAdyacencia.get(origen).add(new Carretera(destino, tiempo));
        listaAdyacencia.get(destino).add(new Carretera(origen, tiempo));  // Grafo no dirigido
    }

    // Implementación del algoritmo de Dijkstra
    public void dijkstra(int centroPrincipal) {
        // Arreglo para almacenar el tiempo mínimo desde el centro principal a cada centro
        int[] tiempoMinimo = new int[numCentros];
        Arrays.fill(tiempoMinimo, Integer.MAX_VALUE);  // Inicializamos todos los tiempos a infinito
        tiempoMinimo[centroPrincipal] = 0;  // El tiempo del centro principal a sí mismo es 0

        // Cola de prioridad para seleccionar el centro con el menor tiempo estimado
        PriorityQueue<Carretera> pq = new PriorityQueue<>((a, b) -> a.tiempo - b.tiempo);
        pq.add(new Carretera(centroPrincipal, 0));

        while (!pq.isEmpty()) {
            Carretera carreteraActual = pq.poll();
            int centroActual = carreteraActual.destino;

            // Revisamos todas las carreteras adyacentes (centros conectados) al centro actual
            for (Carretera adyacente : listaAdyacencia.get(centroActual)) {
                int nuevoTiempo = tiempoMinimo[centroActual] + adyacente.tiempo;

                // Si encontramos un camino más corto, actualizamos el tiempo mínimo
                if (nuevoTiempo < tiempoMinimo[adyacente.destino]) {
                    tiempoMinimo[adyacente.destino] = nuevoTiempo;
                    pq.add(new Carretera(adyacente.destino, nuevoTiempo));  // Añadimos la carretera a la cola de prioridad
                }
            }
        }

        // Mostrar los resultados
        System.out.println("Tiempo mínimo de entrega desde el centro principal " + centroPrincipal + " a los demás centros:");
        for (int i = 0; i < numCentros; i++) {
            System.out.println("Centro " + centroPrincipal + " -> Centro " + i + " : " + tiempoMinimo[i] + " minutos");
        }
    }
}

public class LogisticaDistribucion {
    public static void main(String[] args) {
        // Creamos una red de distribución con 6 centros de distribución
        RedDistribucion red = new RedDistribucion(6);

        // Agregamos las carreteras con sus tiempos de viaje en minutos
        red.agregarCarretera(0, 1, 7);
        red.agregarCarretera(0, 2, 9);
        red.agregarCarretera(0, 5, 14);
        red.agregarCarretera(1, 2, 10);
        red.agregarCarretera(1, 3, 15);
        red.agregarCarretera(2, 3, 11);
        red.agregarCarretera(2, 5, 2);
        red.agregarCarretera(3, 4, 6);
        red.agregarCarretera(4, 5, 9);

        // Aplicamos Dijkstra desde el centro de distribución principal (centro 0)
        red.dijkstra(0);
    }
}
