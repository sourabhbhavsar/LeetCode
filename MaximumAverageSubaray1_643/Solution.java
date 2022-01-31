class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        double ans = -Double.MAX_VALUE;   // Double.MIN_VALUE is the smallest positive double value
        int begin = 0;
        int end = 0;
        double sum = 0;
        int count = 0;
        
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        
        ans = Math.max(ans, sum / (k * 1.0));
        
        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k];
            ans = Math.max(ans, sum / (k * 1.0));
        }
        
        return ans;
    }
}
