import java.util.*;
public class shortestpathbellmanford {
    ArrayList<ArrayList<int[]>> adj;
    int[] distances;
    shortestpathbellmanford(int v){
        adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        distances=new int [v];
        for(int i=0;i<v;i++){
            distances[i]=Integer.MAX_VALUE;
        }
    }
    public void addedge(int u,int v,int w){
        adj.get(u).add( new int[] {v,w});
    }

    public void bellman(int src,int v){
        distances[src]=0;
        for(int i=0;i<v-1;i++){
            for(int u=0;u<v;u++){
            for(int[] s:adj.get(u)){
                int start=u;
                int end=s[0];
                int weigh=s[1];
                if(distances[start]!=Integer.MAX_VALUE && distances[end]>distances[start]+weigh){
                    distances[end]=distances[start]+weigh;
                }
            }}

        }

        for(int i=0;i<v;i++){
            for(int[] q: adj.get(i)){
                int st=i;
                int dt=q[0];
                int wt=q[1];
                if(distances[st]!=Integer.MAX_VALUE && distances[st]+wt < distances[dt]){
                    System.out.println("Infinite Cycle");
                    return;
                }

            }
        }
        for(int i=0;i<v;i++){
            System.out.print(distances[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int v= sc.nextInt();
        int e= sc.nextInt();
        shortestpathbellmanford sp= new shortestpathbellmanford(v);
        for(int i=0;i<e;i++){
            int start= sc.nextInt();
            int end= sc.nextInt();
            int weight= sc.nextInt();
            sp.addedge(start,end,weight);
        }
        sp.bellman(0, v);
        sc.close();
    }

}
