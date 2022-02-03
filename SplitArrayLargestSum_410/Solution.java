class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        long largestNum = Arrays.stream(nums).max().getAsInt();
        
        if (m == 1) {
            return (int)sum;
        }
        
        long low = largestNum;
        long high = sum;
        
        while (low < high) {
            long mid = (low + high) / 2;
            
            if (isMcutPossibleWithSumNoLargerThan(nums, m, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        
        return (int)low;
    }
    
    boolean isMcutPossibleWithSumNoLargerThan(int[] nums, int m, long target) {
        long sum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > target) {
                sum = nums[i];
                count++;
                
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
