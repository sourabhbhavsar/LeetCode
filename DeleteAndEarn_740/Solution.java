class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        
        int[] buckets = new int[max + 1];
        for (int n : nums) {
            buckets[n] = buckets[n] + n;
        }
        
        
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = buckets[1];
        
        for (int i = 2; i <= max; i++) {
            int skip = dp[i - 1]; // if you skip this then the max score at this point is same as last point
            int take = buckets[i] + dp[i - 2]; // if you take this, then you will have to delete i + 1 and i - 1
                                               // and they can't contribute to score, hence it will score at i - 1 + this 
            
            dp[i] = Math.max(skip, take);
        }
        
        return dp[max];
    }
    
}
