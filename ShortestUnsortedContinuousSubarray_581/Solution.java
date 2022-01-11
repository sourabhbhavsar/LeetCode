class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -2;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            
            // search for the last number that is less than the max seen so far.
            if (nums[i] < max) {
                end = i;
            }
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
             min = Math.min(min, nums[i]);
            
            // search for the last number that is more than min seen so far.
            if (nums[i] > min) {
                start = i;
            }
        }
        
        return end - start + 1;
    }
}
