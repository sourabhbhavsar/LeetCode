class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int[] cummulativeSum = new int[nums.length + 1];
        cummulativeSum[0] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cummulativeSum[i + 1] = cummulativeSum[i] + nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            int sumLeft = cummulativeSum[i];
            int sumRight = cummulativeSum[nums.length] - sumLeft - nums[i];
            
            if (sumLeft == sumRight) {
                return i;
            }
        }
        
        return -1;
    }
}
