class Solution {
    int mod = 1000000007;
    public int numWays(int steps, int arrLen) {
        //Map<String, Integer> memo = new HashMap<>();
        //return helper(steps, arrLen - 1, 0, memo);
        int maxPos = Math.min(steps, arrLen);
        long[][] dp = new long[steps + 1][maxPos + 1];
        dp[1][0] = 1; // 1 step to move from 0 to 0
        if (arrLen > 1) {
            dp[1][1] = 1; // 1 step to move from 1 to 0;
        }
        
        for (int s = 2; s <= steps; s++) {
            for (int p = 0; p < maxPos; p++) {
                dp[s][p] = (dp[s - 1][p] + dp[s - 1][p + 1] + (p > 0 ? dp[s - 1][p - 1] : 0)) % mod;
            }
        }
        
        return (int)dp[steps][0];
    }
    
     public int numWays1(int steps, int arrLen) {
        int maxPos = Math.min(steps,arrLen);
        long[][] dp = new long[steps+1][maxPos+1];
        
        dp[1][0]=1;
        dp[1][1]=1;
        for(int i = 2; i <= steps; i++) {
            for(int j = 0; j < maxPos; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1] + (j>0?dp[i-1][j-1]:0))%1000000007;
            }
        }
        
        return (int)dp[steps][0];
    }
    
    public int helper(int steps, int high, int pos, Map<String, Integer> memo) {
        if (pos < 0 || pos > high) {
            return 0;
        }
        
        if (steps < 0) {
            return 0;
        }
        
        if (steps == 0 && pos == 0) {
            return 1;
        }
        
        String key = steps + "_" + pos;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int ans =  (int)(helper(steps - 1, high, pos + 1, memo) + helper(steps - 1, high, pos - 1, memo)
            + helper(steps - 1, high, pos, memo)) % mod;
        
        memo.put(key, ans);
        return ans;
    }
}
