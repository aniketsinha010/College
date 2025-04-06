package Exam_DAA;

import java.util.*;

class Edge {
    int dest, weight;

    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class Assignment15 {

    public static void dijkstra(Map<Integer, List<Edge>> graph, int source, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            if (!graph.containsKey(u)) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Dijkstra - Shortest distances from node " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    // === Part 2 ===

    // Bellman-Ford handles negative weights and non-negative weight cycles
    public static void bellmanFord(int[][] edges, int V, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges (V-1) times
        for (int i = 1; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], weight = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles (optional based on your constraints)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains a negative weight cycle.");
                return;
            }
        }

        System.out.println("Bellman-Ford - Shortest distances from node " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    public static void main(String[] args) {
        // === Dijkstra Example ===
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, new ArrayList<>());

        System.out.println("=== Dijkstra's Algorithm ===");
        dijkstra(graph, 0, 4);

        // === Bellman-Ford Example ===
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 1},
            {2, 1, 2},
            {1, 3, 1},
            {2, 3, 5}
        };

        System.out.println("\n=== Bellman-Ford Algorithm ===");
        bellmanFord(edges, 4, 0);
    }
}
