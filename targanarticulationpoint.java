import java .util.*;

public class targanarticulationpoint {
   ArrayList<ArrayList<Integer>>adj;
    
    int time;
    ArrayList<Integer>apoint;
    targanarticulationpoint(int v){
        adj=new ArrayList<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());

        }
        apoint=new ArrayList<>();
    }
    public void addedge(int a,int b){
        adj.get(a).add(b);
        adj.get(b).add(a);

    }
    public void dfs(int node,int parent,boolean[]visited,int[]dis,int[]low){
        visited[node]=true;
        dis[node]=low[node]=++time;
        int child=0;
        for(int k:adj.get(node)){
            if(k==parent){
                continue;
            }
            if(!visited[k]){
                dfs(k,node,visited,dis,low);
                low[node]=Math.min(low[node],low[k]);
                if(parent!=-1 && dis[node]<=low[k]&& !apoint.contains(node)){
                    apoint.add(node);
                }
                child++;
            }
            else{
                low[node]=Math.min(low[node],dis[k]);
            }
       
        }
        if(parent==-1&&child>1&&!apoint.contains(node)){
            apoint.add(node);
        }

    }
    public void printapoint(int v){
        boolean[] visited=new boolean[v+1];
        int []dis=new int[v+1];
        int []low=new int [v+1];
        for(int i=1;i<=v;i++){
            dfs(i, -1, visited, dis, low);
        }
        System.out.println("Articulation Point ");
        for(int p: apoint){
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        targanarticulationpoint t= new targanarticulationpoint(v);
        for(int i=0;i<e;i++){
           int a= sc.nextInt();
           int b=sc.nextInt();
            t.addedge(a, b);
        }
        t.printapoint(v);
        sc.close();
    }
}
