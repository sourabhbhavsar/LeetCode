class Solution {
    public int coinChange(int[] coins, int amount) {
        //int ans = coinChangeHelper(coins, amount, coins.length);
        int ans = coinChangeBottomUp(coins, amount, coins.length);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        
        return ans;
    }
    
    public int coinChangeBottomUp(int[] coins, int amount, int n) {
        int[] table = new int[amount + 1];
        
        // no coins required to make amount 0
        table[0] = 0;
        
        for (int amt = 1; amt <= amount; amt++) {
            table[amt] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (coins[i] <= amt) {
                    if (table[amt - coins[i]] != Integer.MAX_VALUE) {
                        int c = table[amt - coins[i]] + 1;
                        table[amt] = Math.min(table[amt], c);
                    }
                }
            }
        }
        
        return table[amount];
        
    }
    
    public int coinChangeHelper(int[] coins, int amount, int n) {
        if (amount == 0) {
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                int including = coinChangeHelper(coins, amount - coins[i], n);
                
                if (including != Integer.MAX_VALUE) {
                    including = including + 1;
                }
                
                if (including < ans) {
                    ans = including;
                }
            }
        }
        
        return ans;
    }
}
