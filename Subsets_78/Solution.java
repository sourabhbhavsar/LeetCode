class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        subsetsHelper(nums, 0, subset, out);
        return out;
    }
    
    private void subsetsHelper(int[] nums, int start, List<Integer> subset, List<List<Integer>> out) {
        out.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset, out);
            subset.remove(subset.size() - 1);
        }
    }
}
