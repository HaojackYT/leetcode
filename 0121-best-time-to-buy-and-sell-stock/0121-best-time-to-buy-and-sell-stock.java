class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 2) {
            if (prices[0] < prices[1]) {
                return prices[1] - prices[0];
            }
        }

        int buy = 0, sell = 0, profit = 0;
    
        for (int i = 1; i < n; i++) {

            if (buy <= sell) {
                sell = i;
            }

            if (prices[buy] > prices[i]) {
                buy = i;
            }
            
            if (buy < sell && profit < prices[sell] - prices[buy]) {
                profit = prices[sell] - prices[buy];
            }
        }

        return profit;
    }
}