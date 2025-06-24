public class MaxProfitFromStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    //using brute force approach
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }

    //one pass linear solution
    public static int maxProfit2(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            minProfit = Math.min(minProfit, price);
            maxProfit = Math.max(maxProfit, price - minProfit);
        }
        return maxProfit;
    }
}
