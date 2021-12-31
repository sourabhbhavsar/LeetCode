class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        
        for (int i = 0; i < 32; i++) {
            int numberOfItemWithLastBitOn = 0;
            for (int j = 0; j < n; j++) {
                if ((nums[j] & 1) == 1) {
                    numberOfItemWithLastBitOn++;
                }
                
                nums[j] = nums[j] >>> 1;
            }
            
            ans = ans + numberOfItemWithLastBitOn * (n - numberOfItemWithLastBitOn);
        }
        
        return ans;
    }
}
