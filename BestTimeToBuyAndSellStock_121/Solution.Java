class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        int maxTillHere = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            
            if (prices[i] - minPrice > maxTillHere) {
                maxTillHere = prices[i] - minPrice;
            }
            
            if (maxTillHere > maxSoFar) {
                maxSoFar = maxTillHere;
            }
            
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        
        return (maxSoFar < 0) ? 0 : maxSoFar;
    }
}
