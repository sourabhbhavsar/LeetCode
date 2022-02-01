class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThan = 0;
        int countOfTarget = 0;
        
        for (int n : nums) {
            if (n < target) {
                lessThan++;
            }
            else if (n == target) {
                countOfTarget++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < countOfTarget; i++) {
            ans.add(lessThan++);
        }
        
        return ans;
    }
}
