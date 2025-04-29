import java.util.*;

public class mstusingprimswithedge {
    ArrayList<ArrayList<int[]>> adj;
    boolean[] visited;

    mstusingprimswithedge(int v) {
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[v];
    }

    public void addedge(int start, int end, int weight) {
        adj.get(start).add(new int[]{end, weight});
        adj.get(end).add(new int[]{start, weight});
    }

    public void prim(int src, int v) {
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, -1}); // node, weight, parent

        List<String> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] l = pq.poll();
            int node = l[0];
            int weight = l[1];
            int parent = l[2];

            if (visited[node]) continue;

            visited[node] = true;
            cost += weight;

            if (parent != -1) {
                mstEdges.add(parent + " - " + node + " (weight: " + weight + ")");
            }

            for (int[] neigh : adj.get(node)) {
                int next = neigh[0];
                int wt = neigh[1];
                if (!visited[next]) {
                    pq.add(new int[]{next, wt, node});
                }
            }
        }

        System.out.println("The edges in the MST are:");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }

        System.out.println("The minimum cost is " + cost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        mstusingprimswithedge ms = new mstusingprimswithedge(v);
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            ms.addedge(start, end, weight);
        }
        ms.prim(0, v);
        sc.close();
    }
}

/*5 6
0 1 2
0 3 6
1 2 3
1 3 8
1 4 5
2 4 7
 */