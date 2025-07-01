import java.util.*;
public class knapsack01{
    public static int maximumprofit(int capacity,int itemnumbers,int [] weight,int[] profit){
        int maxprofit=0;
        int [][] dp=new int[itemnumbers+1][capacity+1];
        for(int i=0;i<=itemnumbers;i++){
            for(int w=0;w<=capacity;w++){
                if(i==0||w==0){
                    dp[i][w]=0;
                }
                else if(weight[i-1]<=w){
                    dp[i][w]=Math.max(dp[i-1][w],profit[i-1]+dp[i-1][w-weight[i-1]]);
                }
                else{
                    dp[i][w]=dp[i-1][w];
                }
            }

        }
        maxprofit=dp[itemnumbers][capacity];
        return maxprofit;
    };
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int itemnumber=sc.nextInt();
        int capacity=sc.nextInt();
        int [] itemlist=new int[itemnumber];
        int [] weightlist=new int[itemnumber];
        int []profitlist=new int[itemnumber];

        for(int i=0;i<itemnumber;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
             itemlist[i]=a;
             weightlist[i]=b;
             profitlist[i]=c;
        }
        System.out.println(maximumprofit(capacity,itemnumber,weightlist,profitlist));
        sc.close();

    }
}