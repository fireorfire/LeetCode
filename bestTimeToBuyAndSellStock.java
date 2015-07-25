public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int max = 0;
        int minI = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] < prices[minI]) minI = i;
            int tem = prices[i] - prices[minI];
            if(tem > max) max = tem;
        }
        return max;
    }
}