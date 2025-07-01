import java.util.*;
public class activityproblem {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[][]=new int[n][3];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[i][0]=i+1;
            arr[i][1]=a;
            arr[i][2]=b;

        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[2],b[2]));//assending order . b[2],a[2] will be dessending
        ArrayList<Integer>act=new ArrayList<>();
        act.add(arr[0][0]);
        int endpoint=arr[0][2];
        for(int i=1;i<n;i++){
            if(arr[i][1]>=endpoint){
                act.add(arr[i][0]);
                endpoint=arr[i][2];
            }
        }
        for(int i:act){
            System.out.println(i);
            /*if(i<act.size()){
                System.out.print(" ");
            }*/
        }
        System.out.println();
        sc.close();
    }
}
