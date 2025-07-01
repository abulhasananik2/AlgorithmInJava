import java.util.*;
public class LCS_Substring{
    public static String commonsubstring(String s1, String s2){
        int l1=s1.length();
        int l2=s2.length();
        int [][] dp=new int[l1+1][l2+1];
        int maxlength=0;
        int lastindex=0;
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>maxlength){
                        maxlength=dp[i][j];
                        lastindex=i-1;
                    }
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        StringBuilder s3=new StringBuilder();
        for(int i=lastindex;i>lastindex-maxlength;i--){
            s3.append(s1.charAt(i));
        }
        String s=s3.reverse().toString();
        
        return s;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        String s=commonsubstring(s1, s2);
        int k=s.length();
        System.out.println(s);
        System.out.println(k);
        sc.close();
    }
}