class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int max = 1;
        for (int i = 1 ; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                lis[i] = lis[i - 1] + 1;
            }
            else {
                lis[i] = 1;
            }
            
            max = Math.max(lis[i], max);
        }
        
        return max;
    }
}
