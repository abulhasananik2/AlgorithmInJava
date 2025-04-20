import java.util.*;
public class targanbridge {
    ArrayList<ArrayList<Integer>>adj;
     int tim=0;
     targanbridge(int v){
        adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
     }
    public void addedge(int a,int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
     }
    public  void dfs(int node,int parent,boolean[]visited,int[] dis,int []low){
        visited[node]=true;
        dis[node]=low[node]=tim++;
        for(int p : adj.get(node)){
            if(p==parent){
                continue;
            }
            if(!visited[p]){
                dfs(p, node, visited, dis, low);
                low[node]=Math.min(low[node], low[p]);
                if(low[p]>dis[node]){
                    System.out.println(node+" --> "+p);
                }
            }
            else{
                low[node]=Math.min(low[node], dis[p]);

            }
        }
    }
    public void findbridge(int v){
        boolean [] visited = new boolean[v];
        int [] dis= new int[v];
        int [] low= new int [v];
        tim=0;
        for(int i=0;i<v;i++){
            dfs(i, -1, visited, dis, low);
        } 
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int v= sc.nextInt();
        int e=sc.nextInt();
        targanbridge t = new targanbridge(v);
        for(int i=0;i<e;i++){
            int x = sc.nextInt();
            int y= sc.nextInt();
            t.addedge(x, y);
        }
        t.findbridge(v);
        sc.close();
    }

}
