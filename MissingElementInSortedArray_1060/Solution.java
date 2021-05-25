class Solution {
    public int missingElement(int[] nums, int k) {
        int length = nums.length;
        int low = 0;
        int high = nums.length - 1;
        
        // total missing numbers in the array, if no numbers woud have been missing then 
        // the last number would be nums[0] + length - 1. But, because there are numbers missing
        // the last number is nums[nums.length - 1]. Hence, the count of missing nnumbers
        // between start and end is nums[nums.length - 1] - (nums[0] + length - 1)
        // nums[nums.length - 1] - nums[0] - length + 1
        int countOfMissingNumbers = nums[nums.length - 1] - nums[0] - length + 1;
        
        if (countOfMissingNumbers < k) {
            return nums[nums.length - 1] - countOfMissingNumbers + k;
        }
        
        // loop should end when low and high are an index apart, as tthen Kth missing number would lie between them. That is why the following loop will break when there low and high are adjacent.
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            
            int countMissingNumsHere = nums[mid] - nums[low] - (mid - low);
            
            if (countMissingNumsHere >= k) {
                high = mid;
            }
            else {
                low = mid;
                k = k - countMissingNumsHere;
            }
        }
        
        return nums[low] + k;
    }
}
