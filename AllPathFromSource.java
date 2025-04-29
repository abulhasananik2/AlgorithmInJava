import java . util .*;

public class AllPathFromSource {
    static ArrayList<ArrayList<Integer>> adj;
    
    static int count=0;
    AllPathFromSource(int v){
        adj= new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }
    public  void dfs(int src ,int des , String path ){
        if(src==des){
            System.out.println(path+src);
            count++;
        }
        else{
            for(int neigh: adj.get(src)){
                dfs(neigh,des,path+src);
            }
        }
    }
   
    public static void main(String [] args){
         Scanner sc = new Scanner(System.in);
        int v= sc.nextInt();
        int e= sc.nextInt();
        AllPathFromSource aps = new AllPathFromSource(v);
        for(int i=0;i<e;i++){
            int a=sc.nextInt();
            int b= sc.nextInt();
            adj.get(a).add(b);
        }
        int s= sc.nextInt();
        int d=sc.nextInt();
        aps.dfs(s, d, "");
        System.out.println(count);
        sc.close();

    }
}
