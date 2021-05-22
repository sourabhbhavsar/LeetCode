class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> comb = new ArrayList<>();  
        List<List<Integer>> combinations = new ArrayList<>();
        
        findCombinations(combinations, candidates, comb, target, 0);
        
        return combinations;
    }
    
    public void findCombinations(List<List<Integer>> combinations, 
                                 int[] candidates,  
                                 List<Integer> comb, 
                                 int target, 
                                 int start) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(comb));
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (comb.contains(candidates[i])) {
                //continue;
            }   
            
            comb.add(candidates[i]);
            findCombinations(combinations, candidates, comb, target - candidates[i], i);
            comb.remove(comb.size() - 1);
        }
    }
}
