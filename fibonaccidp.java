import java.util.*;
public class fibonaccidp{
    public static  int fibo(int n){
        if(n<=1){
            return n;
        }

       /*  int []arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
    return arr[n];*/
    int temp1=0;
    int temp2=1;
    int temp=0;
    for(int i=2;i<=n;i++){
        temp=temp1+temp2;
        temp1=temp2;
        temp2=temp;
    }
    return temp;
    }
 
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        System.out.println(fibo(n));
        sc.close();
    }
}