class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int countZero = 0;
        int maxWindow = 0;

        
        int n = nums.length;
        
        for (int j = 0; j < n; j++) {
            
            if (nums[j] == 0) {
                countZero++;
            }
            
            // when count fo zeroes are more than k then we increment i;
            while (countZero > k) {
                if (nums[i] == 0) {
                    countZero--;
                }
                
                i++;
            }
            
            int windowSize = j - i + 1;
            if (maxWindow < windowSize) {
                maxWindow = windowSize;
            }
        }
        return maxWindow;
    }
}
