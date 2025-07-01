import java.util.*;
public class LCS_Subsequence {
    public static String lcs(String S1,String S2){
        int l1=S1.length();
        int l2=S2.length();
        int [][] dp= new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                if(i==0||j==0){
                    dp[i][j]=0;

                }
                else if(S1.charAt(i-1)==S2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;

                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int a=l1;
        int b=l2;
        while(a>0&&b>0){
            if(S1.charAt(a-1)==S2.charAt(b-1)){
                sb.append(S1.charAt(a-1));
                a--;
                b--;
            }
            else if(dp[a-1][b]>dp[a][b-1]){
                a--;
            }
            else {
                b--;
            }
        }
        String s3=sb.reverse().toString();
        return s3;
    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        String ans=lcs(str1,str2);
        int len=ans.length();
        System.out.println(ans+" "+len);
        sc.close();
    }

}
