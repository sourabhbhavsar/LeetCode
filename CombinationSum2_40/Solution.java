class Solution {
    
    // Time Complexity: O(2N)\mathcal{O}(2^N)O(2N)
    // Space Complexity: O(N)\mathcal{O}(N)O(N)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(candidates, 0, target, ans, new ArrayList<>());
        
        return ans;
    }
    
    void  backtrack(int[] candidates, int index, int target, List<List<Integer>> ans, List<Integer> curr) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
        }
        else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                
                curr.add(candidates[i]);
                
                backtrack(candidates, i + 1, target - candidates[i], ans, curr);
                
                curr.remove(curr.size() - 1);
            }
        }
    }
}
