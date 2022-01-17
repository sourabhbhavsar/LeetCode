class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        
        return ans;
    }
}
