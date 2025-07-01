/* 

import java.util.*;
public class rodcutting {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); 
        System.out.print("Take the length : ");
        int len=sc.nextInt();
        int [] prices=new int[len];
        for(int i=0;i<len;i++){
            int a=sc.nextInt();
            prices[i]=a;
        }
        int [][]dp=new int[len+1][len+1];
        for(int i=0;i<=len;i++){
            dp[0][i]=0;
            dp[i][0]=0;
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(j<=i){
                    dp[i][j]=Math.max(dp[i][j-1],prices[j-1]+dp[i-j][j]);
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }

        }
        System.out.println(dp[len][len]);
        sc.close();
    }
}


import java.util.*;

public class rodcutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rod length: ");
        int len = sc.nextInt();

        int[] prices = new int[len];
        System.out.println("Enter prices for lengths 1 to " + len + ":");
        for (int i = 0; i < len; i++) {
            prices[i] = sc.nextInt();
        }

        int[] dp = new int[len + 1];
        int[] cuts = new int[len + 1]; // To track the cuts

        for (int i = 1; i <= len; i++) {
            int maxVal = -1;
            for (int j = 1; j <= i; j++) {
                if (maxVal < prices[j - 1] + dp[i - j]) {
                    maxVal = prices[j - 1] + dp[i - j];
                    cuts[i] = j;
                }
            }
            dp[i] = maxVal;
        }

        System.out.println("Maximum revenue: " + dp[len]);
        System.out.print("Cuts: ");
        int n = len;
        while (n > 0) {
            System.out.print(cuts[n] + " ");
            n -= cuts[n];
        }
        System.out.println();
        sc.close();
    }
}
 */

 import java.util.*;
 public class rodcutting{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=sc.nextInt();
        }
        int[] dp=new int[n+1];
        int[] cuts=new int[n+1];
        for(int i=1;i<=n;i++){
            int max=-1;
            for(int j=1;j<=i;j++){
                if((prices[j-1]+dp[i-j])>max){
                    max=prices[j-1]+dp[i-j];
                    cuts[i]=j;
                }
            }
            dp[i]=max;

        }
        System.out.println(dp[n]);
        int k=n;
        while(k>0){
            System.out.print(cuts[k]+" ");
            k=k-cuts[k];
        }
        sc.close();
    }
 }