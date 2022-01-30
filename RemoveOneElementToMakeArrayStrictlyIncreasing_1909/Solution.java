class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        boolean used = false;
        int previous = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] <= previous) {
                if (used) {
                    return false;
                }
                
                used = true;
                if (i == 1 || nums[i] > nums[i - 2]) {
                    previous = nums[i];
                }
            } else {
                previous = nums[i];
            }
        }
        
        return true;
    }
}
