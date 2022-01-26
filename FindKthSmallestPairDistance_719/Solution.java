class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        int smallestDiff = nums[1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            smallestDiff = Math.min(smallestDiff, nums[i + 1] - nums[i]);
        }
        
        int biggestDiff = nums[nums.length - 1] - nums[0];
        
        while (smallestDiff < biggestDiff) {
            int mid = (smallestDiff + biggestDiff) / 2;
            if (countPairsWithDiff(nums, mid) < k) {
                smallestDiff  = mid + 1;
            }
            else {
                biggestDiff = mid;
            }
        }
        
        return smallestDiff;
    }
    
    public int countPairsWithDiff(int[] nums, int diff) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] + diff;
            count = count + (getlastIndexLessThanTarget(nums, i, target) - i);
        }
        
        return count;
    }
    
    public int getlastIndexLessThanTarget(int[] nums, int low, int target) {
        int high = nums.length - 1;
                
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid;
            }
        }
        
        return low;
    }
}
