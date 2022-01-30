class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for (int num : nums) {
            sum = sum + num;
        }
        
        int idealSum = n * (n + 1) / 2;
        return idealSum - sum;
    }
}
