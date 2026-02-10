class PrimsAlgorithm {
    static final int V = 5;

    public static void main(String[] args) {
        int INF = 9999999;
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        boolean[] selected = new boolean[V];
        selected[0] = true;
        int edges = 0;
        System.out.println("Edge : Weight");
        while (edges < V - 1) {
            int min = INF;
            int x = 0, y = 0;
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && graph[i][j] != 0) {
                            if (graph[i][j] < min) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " : " + graph[x][y]);
            selected[y] = true;
            edges++;
        }
    }
}