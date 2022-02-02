class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        int[] money = new int[n];
        money[0] = nums[0];
        money[1] = Math.max(nums[1], nums[0]);
        
        for (int i = 2; i < n; i++) {
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        
        return money[n - 1];
    }
}
