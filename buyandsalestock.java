/*Problem Statement 3: Best Time to Buy and Sell Stock

Problem Statement: You are given comma separated prices which contain the price of a stock on some days. You have to choose one day for buying the stock and a different one for selling it. Your task is to determine the maximum profit you can achieve from a single buy-sell transaction, where the buy day must come before the sell day. If no profit is possible, return 0.

Example:

Input: 
An integer n (1 ≤ n ≤ 10⁵): the number of days
A comma-separated list of n integers: the prices of the stock on each day

Example 1 : 
6
 7,1,5,3,6,4

Output: 5  
Explanation: Buy on day 2 (price = 1), sell on day 5 (price = 6), profit = 6 - 1 = 5. */
import java.util.*;
public class buyandsalestock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int days=sc.nextInt();
        sc.nextLine();
        String []s=sc.nextLine().split(",");
        int []prices=new int [days];
        for(int i=0;i<days;i++){
            prices[i]=Integer.parseInt(s[i].trim());
        }
        int minimum=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int price:prices){
             minimum=Math.min(price,minimum);
             int currentprofit=price-minimum;
             maxprofit=Math.max(currentprofit,maxprofit);
        }
        System.out.println(maxprofit);
        sc.close();

    }
}
