public class maximumrockclimbing {
    public static int maximumval(int[][]wall){
        int rows=wall.length;
        int cols=wall[0].length;
        int[][] dp=new int [rows][cols];
        for(int j=0;j<cols;j++){
             dp[rows-1][j]=wall[rows-1][j];
        }
        for(int i=rows-2;i>=0;i--){
            for(int j=0;j<cols;j++){
                int maxbelow=dp[i+1][j];
                if(j>0){
                    maxbelow=Math.max(dp[i+1][j-1],maxbelow);
                }
                if(j<cols-1){
                    maxbelow=Math.max(dp[i+1][j+1],maxbelow);
                }
                dp[i][j]=wall[i][j]+maxbelow;
            }
        }
        int max=dp[0][0];
        for(int j=1;j<cols;j++){
            if(dp[0][j]>max){
                max=dp[0][j];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int [][] walls={
            
  {1, 2, 3},
  {4, 5, 6},
  {7, 8, 9}  

        };
        System.out.println(maximumval(walls));

    }
}
