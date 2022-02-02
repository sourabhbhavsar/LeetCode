class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, 1, ans, new ArrayList<>());
        
        return ans;
    }
    
    void backtrack(int n, int k, int index, List<List<Integer>> ans, List<Integer> comb) {
        if (comb.size() == k) {
            ans.add(new ArrayList<>(comb));
        }
        else {
            for (int i = index; i <= n; i++) {
                comb.add(i);
                backtrack(n, k, i + 1, ans, comb);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
