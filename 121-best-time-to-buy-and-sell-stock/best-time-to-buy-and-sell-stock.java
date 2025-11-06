class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int prof = 0;

        for(int i = 0; i < prices.length; i++){
            int cost = prices[i] - min;
            prof = Math.max(prof, cost);
            min = Math.min(min, prices[i]);
        }
        return prof;
    }
}