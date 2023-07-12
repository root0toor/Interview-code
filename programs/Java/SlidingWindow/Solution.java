package SlidingWindow;

public class Solution {
    public static int maxProfit(int[] prices) {
        int p1 = 0;
        int p2 = 1;
        int maxProfit = 0;
        for (int i=0; i<prices.length;i++){
            maxProfit = Integer.max(maxProfit, i);
        }
        return 0;
    }
    public static void main(String[] args){
        int[] input = new int[] {7,1,5,3,6,4};
        int maxProfit = maxProfit(input);
        System.out.println("    ===     Max Profit is   ===     " + maxProfit);
    }
}
