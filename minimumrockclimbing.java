import java.util.*;
public class minimumrockclimbing {
    public static void minrockkclimbing(int [][]wall){
        int row=wall.length;
        int col=wall[0].length;
        int [][] dp= new int[row][col];
        for(int j=0;j<col;j++){
            dp[row-1][j]=wall[row-1][j];
        }
        int min=0;
        for(int i=row-2;i>=0;i--){
            for(int j=0;j<col;j++){
                min=dp[i+1][j];
                if(j>0){
                    min=Math.min(min,dp[i+1][j-1]);
                }
                if(j<col-1){
                    min=Math.min(min,dp[i+1][j+1]);
                }
                dp[i][j]=min+wall[i][j];
            }
        }
        int minimum=dp[0][0];
        for(int j=0;j<col;j++){
            if(dp[0][j]<minimum){
                minimum=dp[0][j];
            }
        }
        int []arr=new int[row];
        for(int i=0;i<row;i++){
            int mini=dp[i][0];
            arr[i]=wall[i][0];
            for(int j=0;j<col;j++){
                   if(dp[i][j]<mini){
                    arr[i]=wall[i][j];
                    mini=wall[i][j];
                   }

                
            }
        }
        System.out.println(minimum);
        for(int i=row-1;i>=0;i--){
            System.out.print(arr[i]);
            if(i!=0){
                System.out.print(" ");
            }
        }

    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int [][] wall=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int a=sc.nextInt();
                wall[i][j]=a;
            }
        }
        minrockkclimbing(wall);
        sc.close();
    }
}
