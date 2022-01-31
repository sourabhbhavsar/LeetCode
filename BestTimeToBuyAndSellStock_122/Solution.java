class Solution {
    public int maxProfit(int[] prices) {
        // int[] memo = new int[prices.length];
        // Arrays.fill(memo, -1);
        
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        int buy = 0;
        int sell = 0;
        int profit = 0;
        int i = 0;
        int j = 0;
        
        while (i < n && j < n) {
            // find the valley of prices i.e the smallest in a decresing streak.
            while (i + i < n && prices[i + 1] < prices[i]) {
                i++;
            }
            
            buy = prices[i];
            
            // find the peak of prices i.e the highest in a increasing streak coming after i.
            j = i;
            while (j + 1 < n && prices[j + 1] > prices[j]) {
                j++;
            }
            
            sell = prices[j];
            profit = profit + (sell - buy);
            
            i = j + 1;
        }
        
        return profit;
        
        // return maxProfitBU(prices);
        //return maxProfitDP(prices, prices.length - 1, memo);
    }
    
    
    
    
    
    public int maxProfitBU(int[] prices) {
        int[] table = new int[prices.length];
        table[0] = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                int profitSoldHere = (prices[i] - prices[j]) + table[j];
                maxProfit = Math.max(profitSoldHere, maxProfit);
            }
            
            int profitNotSoldHere = table[i - 1];
            table[i] = Math.max(profitNotSoldHere, maxProfit);
        }
        
        return table[table.length - 1];
    }
    
    public int maxProfitDP(int[] prices, int sellingDay, int[] memo) {
        if (sellingDay <= 0) {
            return 0;
        }
        
        if (memo[sellingDay] != -1) {
            return memo[sellingDay];
        }
        
        int maxProfit = 0;
        for (int buyingDay = 0; buyingDay < sellingDay; buyingDay++) {
            int profitSoldHere = (prices[sellingDay] - prices[buyingDay]) + maxProfitDP(prices, buyingDay, memo);
            maxProfit = Math.max(maxProfit, profitSoldHere);
        }
        
        int profitNotSoldHere = maxProfitDP(prices, sellingDay - 1, memo);
        
        maxProfit = Math.max(maxProfit, profitNotSoldHere);
        
        memo[sellingDay] = maxProfit;
        return maxProfit;
    }
}
