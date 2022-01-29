class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // mark all negative and > n numbers with n + 1.
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val > n) {
                continue;
            }
            
            int bucket = val - 1; //0 based index. 1 should go in bucket 0.
            if (nums[bucket] > 0) {
                nums[bucket] = -1 * nums[bucket];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}
