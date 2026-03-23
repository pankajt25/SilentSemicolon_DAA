public class BellmanFord {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, -1}, {0, 2, 4}, {1, 2, 3},
            {1, 3, 2},  {1, 4, 2}, {3, 2, 5},
            {3, 1, 1},  {4, 3, -3}
        };

        int[] dist = new int[V];

        // Step 1: Initialize distances
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;

        // Step 2: Relax edges V-1 times
        for (int i = 1; i < V; i++)
            for (int[] e : edges)
                if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]])
                    dist[e[1]] = dist[e[0]] + e[2];

        // Step 3: Check for negative cycle
        for (int[] e : edges)
            if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]]) {
                System.out.println("Negative weight cycle detected!");
                return;
            }

        // Print result
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }
}