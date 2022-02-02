class Solution {
    public int jump(int[] nums) {
        int currEnd = 0;
        int currFarthest = 0;
        int jump = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jump++;
                currEnd = currFarthest;
            }
        }
        
        return jump;
    }
}