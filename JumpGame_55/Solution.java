class Solution {
    public boolean canJump(int[] nums) {
        
        return canJumpGreedy(nums);
    }
    
    public boolean canJumpGreedy(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n; i++) {
            if (farthest < i) {
                return false;
            }
            
            farthest = Math.max(farthest, i + nums[i]);
        }
        
        return true;
    }
    
    public boolean canJumpBU(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        
        for (int i = n - 2; i >= 0; i--) {
            int maxJump = nums[i];
            
            for (int j = 0; j <= maxJump; j++) {
                if (i + j >= n) {
                    break;
                }
                
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[0];
    }
    
    public boolean canJumpDP(int[] nums, int index, Boolean[] memo) {
        if (index < 0 || index >= nums.length) {
            return false;
        }
        
        if (index == nums.length - 1) {
            return true;
        }
        
        if (memo[index] != null) {
            return memo[index];
        }
        
        boolean ans = false;
        for (int i = 1; i <= nums[index]; i++) {
            ans = ans || canJumpDP(nums, index + i, memo);
        }
        
        memo[index] = ans;
        return ans;
    }
}
