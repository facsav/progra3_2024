package clase12;

import java.util.*;

class Almacen {
    private int id;
    private String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}


class Grafo {
    private Map<Integer, Almacen> almacenes; // Almacenes por su ID
    private Map<Integer, List<Integer>> adyacencia; // Lista de adyacencia

    public Grafo() {
        almacenes = new HashMap<>();
        adyacencia = new HashMap<>();
    }


    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adyacencia.putIfAbsent(almacen.getId(), new ArrayList<>());
    }

    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencia.get(id1).add(id2);
            adyacencia.get(id2).add(id1); // Si el grafo es bidireccional
        }
    }


    public void dfs(int idInicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRecursivo(idInicio, visitados);
    }

    private void dfsRecursivo(int idActual, Set<Integer> visitados) {
        if (!visitados.contains(idActual)) {
            visitados.add(idActual);
            System.out.println(almacenes.get(idActual));

            for (int vecino : adyacencia.get(idActual)) {
                if (!visitados.contains(vecino)) {
                    dfsRecursivo(vecino, visitados);
                }
            }
        }
    }

    public void bfs(int idInicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        cola.add(idInicio);
        visitados.add(idInicio);
        System.out.println("Recorrido BFS:");

        while (!cola.isEmpty()) {
            int idActual = cola.poll();
            System.out.println(almacenes.get(idActual));

            for (int vecino : adyacencia.get(idActual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Almacen almacen1 = new Almacen(1, "Almacen Central");
        Almacen almacen2 = new Almacen(2, "Almacen Norte");
        Almacen almacen3 = new Almacen(3, "Almacen Sur");
        Almacen almacen4 = new Almacen(4, "Almacen Este");
        Almacen almacen5 = new Almacen(5, "Almacen Oeste");

        grafo.agregarAlmacen(almacen1);
        grafo.agregarAlmacen(almacen2);
        grafo.agregarAlmacen(almacen3);
        grafo.agregarAlmacen(almacen4);
        grafo.agregarAlmacen(almacen5);


        grafo.conectarAlmacenes(1, 2);
        grafo.conectarAlmacenes(1, 3);
        grafo.conectarAlmacenes(2, 4);
        grafo.conectarAlmacenes(3, 5);
        grafo.conectarAlmacenes(4, 5);


        grafo.dfs(1);
        System.out.println();
        grafo.bfs(1);
    }
}
