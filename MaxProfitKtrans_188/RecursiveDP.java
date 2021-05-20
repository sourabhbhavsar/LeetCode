class RecursiveDP {
    public int maxProfit(int k, int[] prices) {
        int[][] table = new int[k + 1][prices.length + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= prices.length; j++) {
                table[i][j] = -1;
            }
        }
            
        return maxProfitDP(prices, k, prices.length - 1, table);
    }
    
    int maxProfitDP(int[] prices, int k, int sellingDay, int[][] table) {
        if (sellingDay <= 0 ) {
            return 0;
        }
        
        if (k == 0) {
            return 0;
        }
        
        if (table[k][sellingDay] != -1) {
            return table[k][sellingDay];
        }
        
        // not selling on selling day
        int notSoldHere =  maxProfitDP(prices, k, sellingDay - 1, table);
        
        // if we sold here, let us find what would be max profit
		    // if we bought between 0 to a day before selling day
		    // plus max profit in k - 1 transaction till that buying day
        int minPrice = Integer.MAX_VALUE;
        int buyingDay = -1;
        int maxProfitSoFar = 0;
        for (int i = 0; i < sellingDay; i++) 
        {
            int profitSoldHere = prices[sellingDay] - prices[i];
            maxProfitSoFar = Math.max(maxProfitSoFar,
                                     profitSoldHere + maxProfitDP(prices, k - 1, i, table));                         
        }
        
       
        
        int maxProfitHere = Math.max(maxProfitSoFar, notSoldHere);
        
        table[k][sellingDay] = maxProfitHere;
        
        return maxProfitHere;
    }
}
