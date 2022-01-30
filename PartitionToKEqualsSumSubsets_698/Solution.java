class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum = sum + num;
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        int target = sum / k;
        char[] taken = new char[n];
        Arrays.fill(taken, '0');
        Map<String, Boolean> memo = new HashMap<>();
        
        return canPartitionSubsetsBacktrack(nums, 0, 0, 0, k, taken, target, memo);
    }
    
    boolean canPartitionSubsetsBacktrack(int[] nums, int pos, int currSum, int count, int k,
                                         char[] taken, int target, Map<String, Boolean> memo) {
        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }
        
        // No need to proceed further.
        if (currSum > target) {
            return false;
        }
        
        String key = new String(taken);
        
        // If we have already computed the current combination.
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == target) {
            boolean ans = canPartitionSubsetsBacktrack(nums, 0, 0, count + 1, k, taken, target, memo);
            memo.put(key, ans);
            return ans;
        }
        
        // Try not picked elements to make some combinations.
        for (int i = pos; i < nums.length; i++) {
            if (taken[i] == '0') {
                taken[i] = '1';
                // If using current jth element in this subset leads to make all valid subsets.
                if (canPartitionSubsetsBacktrack(nums, i + 1, currSum + nums[i], count, k, taken, target, memo)) {
                    return true;
                }
                taken[i] = '0';
            }
        }
        
        // We were not able to make a valid combination after picking each element from array,
        // hence we can't make k subsets.
        memo.put(key, false);
        return false;
    }
    
}
