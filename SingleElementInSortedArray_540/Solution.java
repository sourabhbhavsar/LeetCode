class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
        
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            // get top the even index
            if (mid % 2 == 1) {
                mid--;
            }
            
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            }
            else {
                high = mid;
            }
        }
        
        return nums[low];
    }
}
