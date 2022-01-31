class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                continue;
            }
            
            if (i == start) {
                ans.add(nums[start] + "");
            }
            else {
                ans.add(nums[start] + "->" + nums[i]);
            }
            
            start = i + 1;
        }
        
        return ans;
    }
}
