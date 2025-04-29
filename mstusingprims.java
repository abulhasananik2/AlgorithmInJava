import java.util.*;
public class mstusingprims {
    ArrayList<ArrayList<int []>>adj;
    boolean [] visited;
    mstusingprims(int v){
        adj= new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        visited= new boolean[v];
    }

    public void addedge(int start,int end, int weight){
        adj.get(start).add(new int[] {end,weight});
        adj.get(end).add(new int [] {start,weight});
    }
    public void prim(int src,int v){
        
        int cost=0;
        PriorityQueue <int []> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int [] {src,0});
        while(!pq.isEmpty()){
            int [] l= pq.poll();
            int dis=l[0];
            if(visited[dis]){
                continue;
            }
            visited[dis]=true;
            
            
            int wei=l[1];
            cost=cost+wei;
            for(int neigh[]: adj.get(dis)){
                if(!visited[neigh[0]]){
                pq.add(neigh);}
            }
            
        }
        System.out.println("The minimum cost is "+cost);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int v= sc.nextInt();
        int e=sc.nextInt();
        mstusingprims ms= new mstusingprims(v);
        for(int i=0;i<e;i++){
           int start= sc.nextInt();
           int end=sc.nextInt();
           int weight=sc.nextInt();
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