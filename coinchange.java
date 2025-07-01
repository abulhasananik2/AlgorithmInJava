import java.util.*;
public class coinchange {
    public static void main(String[] args) {
        int [] taka={10,2,5,20,100,50,200,1000,500};
        Arrays.sort(taka);
        Scanner sc=new Scanner(System.in);
        int money=sc.nextInt();
        int count=0;
        for(int i=taka.length-1;i>=0;i--){
            while(money>=taka[i]){
                money=money-taka[i];
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
