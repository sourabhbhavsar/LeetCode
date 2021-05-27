class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int first = findFirstIndex(nums, target);
        int last = findLastIndex(nums, target);

        return new int[]{first, last};
    }
    
    public int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            
            int mid = (low + high) / 2;
            
            if (nums[mid] >= target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        
        if (nums[low] != target) {
            return -1;
        }
        
        return low;
    }
    
    public int findLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            // make mid biased to right instead of left. Otherwise, we risk getting stuck in perpetual loop.
            int mid = (low + high) / 2 + 1;
            
            if (nums[mid] <= target) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        
        if (nums[low] != target) {
            return -1;
        }
        
        return low;
    }
}
