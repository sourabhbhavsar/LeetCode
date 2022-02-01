class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int begin = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        int sum = 0;
        while (end < n) {
            sum = sum + nums[end];
            
            while (sum >= target) {
                int window = end - begin + 1;
                min = Math.min(min, window);
                
                sum = sum - nums[begin];
                begin++;
            }
            
            end++;
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
