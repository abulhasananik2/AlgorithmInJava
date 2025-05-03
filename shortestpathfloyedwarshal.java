import java.util.*;
public class shortestpathfloyedwarshal {
    static final int inf=1000000000;

    public static void solvetheproblem(int[][] graph, int v){
        int [][] distance= new int[v][v];
        System.out.println("The input graph ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                distance[i][j] = graph[i][j];
                System.out.println(distance[i][j]+" ");
            }
            System.out.println();
        }
        
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<v;k++){
                    if(distance[j][i]<inf && distance [i][k]<inf )
                    distance[j][k]=Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }
        System.out.println("The answer will be ");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(distance[i][j]==inf){
                    System.out.print("inf ");
                }
                else{
                System.out.print(distance[i][j]+" ");
            }
                    }            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int [][] graph=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph[i][j]=inf;
                if(i==j){
                    graph[i][j]=0;
                }
            }
        }
        for(int i=0;i<e;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            int w=sc.nextInt();
            graph[a][b]=w;
        }  
        
        solvetheproblem(graph, v);
        sc.close();
    }
}
