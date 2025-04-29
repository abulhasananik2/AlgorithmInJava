import java.util.*;

public class shortestpathdiskstras {
    static ArrayList<ArrayList<int[]>> adj;

    shortestpathdiskstras(int v) {
        adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void findshortpath(int src, int v, int dis) {
        int dist[] = new int[v + 1]; // FIX 1: size v+1
        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; // FIX 3: source distance = 0

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curren = pq.poll();
            int b = curren[0];
            int w = curren[1];

            if (dist[b] < w) continue;

            for (int neigh[] : adj.get(b)) { // FIX 2: adj.get(b) not adj.get(src)
                int nei = neigh[0];
                int d = neigh[1];

                if (dist[b] + d < dist[nei]) {
                    dist[nei] = dist[b] + d;
                    pq.add(new int[]{nei, dist[nei]});
                }
            }
        }

        if (dist[dis] == Integer.MAX_VALUE) {
            System.out.println("No path exists");
        } else {
            System.out.println(dist[dis]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        shortestpathdiskstras sd = new shortestpathdiskstras(v);

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            adj.get(a).add(new int[]{b, w});
        }

        int src = sc.nextInt();
        int dis = sc.nextInt();

        sd.findshortpath(src, v, dis);
        sc.close();
    }
}
