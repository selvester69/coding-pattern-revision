package leetcode;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int res = BestTimeToBuySellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        System.out.println(res);
    }

    // time limit exceeded on testcase
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buy;
            if (prices[i] < buy) {
                buy = prices[i];
            }
            maxProfit = Math.max(maxProfit, profit);
        }
        if(maxProfit<0){
            return 0;
        }
        return maxProfit;
    }

    // time limit exceeded on testcase
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

}
