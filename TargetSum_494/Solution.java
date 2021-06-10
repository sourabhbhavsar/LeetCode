class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<String, Integer> table = new HashMap<>();
        return findTargetSumWaysHelper(nums, nums.length, target, table);
    }
    
    public int findTargetSumWaysHelper(int[] nums, int n, int target, HashMap<String, Integer> table) {
        if (n == 0) {
            if (target == 0) {
                return 1;
            }
            
            return 0;
        }
        
        String key = n + "," + target;
        if (table.containsKey(key)) {
            return table.get(key);
        }
        
        int minusHere = findTargetSumWaysHelper(nums, n - 1, target + nums[n - 1], table);
        int plushere = findTargetSumWaysHelper(nums, n - 1, target - nums[n - 1], table);
        
        int ans = minusHere + plushere;
        table.put(key, ans);
        return ans;
    }
}
