class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int maxSum = Integer.MIN_VALUE;
        
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum >= k) {
                high--;
            }
            else {
                maxSum = Math.max(maxSum, sum);
                low++;
            }
        }
        
        return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
    }
}
