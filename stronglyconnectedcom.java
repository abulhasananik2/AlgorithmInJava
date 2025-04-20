import java.util.*;
public class stronglyconnectedcom {
    ArrayList<ArrayList<Integer>>adj;
    Stack<Integer>st;
    stronglyconnectedcom(int v){
        adj=new ArrayList<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }
        st = new Stack<>();
    }
    public void addedge(int a,int b){
        adj.get(a).add(b);
    }
    public void toposort(int node, boolean [] visited){
        visited[node]=true;
        for(int l: adj.get(node)){
            if(!visited[l]){
                toposort(l, visited);
            }
        }
        st.push(node);
    }

    public void dfs(int node, boolean [] visited){
        visited[node]=true;
        for(int l: adj.get(node)){
            if(!visited[l]){
                dfs(l, visited);
            }
        }
        //st.push(node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        stronglyconnectedcom scc=new stronglyconnectedcom(v);
        stronglyconnectedcom rev=new stronglyconnectedcom(v);
        for(int i=0;i<e;i++){
            int a= sc.nextInt();
            int b= sc.nextInt();
            scc.addedge(a, b);
            rev.addedge(b, a);
        }
        sc.close();
        boolean []vis=new boolean[v+1];
        for( int i=1;i<=v;i++){
            scc.toposort(i,vis);
        }
        int count=0;
        boolean [] nvis= new boolean[v+1];
        while(!scc.st.empty()){
            int f= scc.st.pop();
            if(!nvis[f]){
                rev.dfs(f, nvis);
                count++;
            }
        }

        System.out.println("# of strongly Connected Components: "+count);
    }
}
