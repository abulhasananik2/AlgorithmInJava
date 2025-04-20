import java.util.*;
public class bfs{
    ArrayList<ArrayList<Integer>>arr;
   public bfs(int v){
        arr=new ArrayList<>();
        for(int i=0;i<v;i++){
            arr.add(new ArrayList<>());       
        }
    }
    public void addedge(int u,int v){
        arr.get(u).add(v);
        arr.get(v).add(u);

    }
    public void solvebfs(int src,int v){
        boolean[] visited= new boolean[v];
        Queue<Integer> q =new LinkedList<>();
        visited[src]=true;
        q.add(src);
        while(!q.isEmpty()){
            int node= q.poll();
            System.out.println(node);
            
                for(int neigh:arr.get(node)){
                    if(!visited[neigh]){
                    visited[neigh]=true;
                    q.add(neigh);
                    }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v= sc.nextInt();
        int e= sc.nextInt();
        bfs b = new bfs(v);
        for(int i=0;i<e;i++){
            int m= sc.nextInt();
            int n= sc.nextInt();
            b.addedge(m, n);
        }
        sc.close();
        b.solvebfs(0, v);
    }

}