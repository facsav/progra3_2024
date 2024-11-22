package Clase13;

import java.util.*;

class Node {
    String name;
    int cost;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class Actividad2 {
    private final Map<String, List<Node>> graph = new HashMap<>();

    public void addEdge(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost));
    }

    public int uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(start, 0));
        Set<String> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.name.equals(goal)) {
                return current.cost;
            }

            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                if (!visited.contains(neighbor.name)) {
                    priorityQueue.add(new Node(neighbor.name, current.cost + neighbor.cost));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Actividad2 ucs = new Actividad2();

        ucs.addEdge("Buenos Aires", "Sao Paulo", 200);
        ucs.addEdge("Buenos Aires", "Santiago", 300);
        ucs.addEdge("Sao Paulo", "Lima", 400);
        ucs.addEdge("Santiago", "Lima", 200);
        ucs.addEdge("Lima", "Mexico", 500);

        // Ejecutar UCS
        String start = "Buenos Aires";
        String goal = "Mexico";
        int totalCost = ucs.uniformCostSearch(start, goal);

        if (totalCost != -1) {
            System.out.println("El costo mínimo desde " + start + " hasta " + goal + " es: " + totalCost);
        } else {
            System.out.println("No se encontró un camino desde " + start + " hasta " + goal);
        }
    }
}
