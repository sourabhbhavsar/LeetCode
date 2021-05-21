class Solution {
    public boolean search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            
            // skip duplicates
            while (low < high && nums[low] == nums[low + 1]) {
                if (nums[low] == nums[low + 1]) {
                    low++;
                }
            }
            
            while (high >    low && nums[high] == nums[high - 1]) {
                high--;
            }
                        
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // if there is a rotation; if the left half is sorted or the right half in unsorted.
            if (nums[mid] > nums[high]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
             // if there is a rotation; if the right half is sorted or the left half in unsorted.
            else if (nums[mid] < nums[low]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            // no rotation
            else {
                if (target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
       
        return false;
    }
    

}
