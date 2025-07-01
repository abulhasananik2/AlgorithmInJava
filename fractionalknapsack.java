import java.util.*;
public class fractionalknapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int itemnumber=sc.nextInt();
        double [][] box=new double[itemnumber][2];
        for(int i=0;i<itemnumber;i++){
            int price=sc.nextInt();
            int ogon=sc.nextInt();
            box[i][0]=price;
            box[i][1]=ogon;
        }
        Arrays.sort(box,(a,b)->{
            double ra=a[0]/a[1];
            double rb=b[0]/b[1];
            return Double.compare(rb,ra);
        });
        double mainbox=sc.nextDouble();
        double profit=0;
        for(int i=0;i<itemnumber;i++){
            if(mainbox<=0) break;
            if(box[i][1]<=mainbox){
                mainbox=mainbox-box[i][1];
                profit=profit+box[i][0];
            }
            else{
                profit=profit+(mainbox*(box[i][0]/box[i][1]));
                mainbox=0;
            }
        }
        System.out.printf("%.3f\n",profit);
        sc.close();
        

    }
}
