class Solution {
    private static final int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        long[] modPow = new long[nums.length + 1];
        modPow[0] = 1;
        for (int i = 1; i < modPow.length; i++) {
            modPow[i] = 2 *  modPow[i - 1] % MOD;
        }
        
        Arrays.sort(nums);
        
        int low = 0;
        int high = nums.length - 1;
        long ans = 0;
        
        while (low <= high) {
            if (nums[low] + nums[high] > target) {
                high--;
            }
            else {
                long currPower = modPow[high - low];
                ans = ans + currPower % MOD;
                low++;
            }
        }
        
        ans = ans % MOD;
        
        return (int) ans;
    }
}
