class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                
                mid++;
                low++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
        
    }
    
}
