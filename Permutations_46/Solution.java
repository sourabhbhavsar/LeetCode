class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        permuteHelper(nums, p, ans, set);
        
        return ans;
    }
    
    public void permuteHelper(int[] nums, 
                              List<Integer> p, 
                              List<List<Integer>> ans, 
                              Set<Integer> set) {
        if (p.size() == nums.length) {
            ans.add(new ArrayList<>(p));
            
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                p.add(nums[i]);
                set.add(nums[i]);
                
                permuteHelper(nums, p, ans, set);
                set.remove(p.get(p.size() - 1));
                p.remove(p.size() - 1); 
            } 
        }
    }
}
