import java.util.*;

public class dfsandtropologicalsort {
    ArrayList<ArrayList<Integer>> adj;
    Stack <Integer> st;
    dfsandtropologicalsort(int v){
        adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        st= new Stack<>();
    }   
    public void addedge(int u,int v){
        adj.get(u).add(v);
    }
    public void dfstropo(int src,boolean [] visited){
        visited[src]=true;
        System.out.println(src);
        for(int n : adj.get(src)){
            if(!visited[n]){
                dfstropo(n, visited);
            }
        }
        st.push(src);
    }

    public static void main(String [] arg){
        Scanner sc=new Scanner(System.in);
        int v =sc.nextInt();
        int e= sc.nextInt();
        dfsandtropologicalsort d = new dfsandtropologicalsort(v);
        for(int i=0;i<e;i++){
            int m=sc.nextInt();
            int n = sc.nextInt();
            d.addedge(m, n);
        }
        sc.close();
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i])
        d.dfstropo(i, visited);}
        System.out.println("topological sorts are : ");
        while (!d.st.isEmpty()) {
           System.out.println(d.st.pop()); 
        }

    }
}
