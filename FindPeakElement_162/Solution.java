class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        return searchPeak(nums, 0, high);
    }
    
    public int searchPeak(int[] nums, int low, int high) {
        
        while (low < high) {
            int mid = (high + low) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
