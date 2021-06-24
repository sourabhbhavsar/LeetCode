class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return maxProductTopDown(nums, nums.length);
    }
    
    public int maxProductTopDown(int[] nums, int n) {
        
        int currMin = nums[0];
        int currMax = nums[0];
        int ans = currMax;
        
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            
            currMax = Math.max(nums[i] * temp, Math.max(currMin * nums[i], nums[i]));
            currMin = Math.min(nums[i] * temp, Math.min(currMin * nums[i], nums[i]));
            
             ans = Math.max(ans, currMax);
        }
        
        return ans;
    }
}
