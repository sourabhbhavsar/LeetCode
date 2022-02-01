class Solution {
    
    // Time Complexity: O(2N⋅N)\mathcal{O}(2^N \cdot N)O(2N⋅N)
    // Space Complexity: O(2N⋅N)\mathcal{O}(2^N \cdot N)O(2N⋅N)
    
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        int n = g.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                graph.get(i).add(g[i][j]);
            }
        }
        
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(graph, 0, n - 1, ans, path);
        
        return ans;
    }
    
    public void backtrack(Map<Integer, Set<Integer>> graph, int curr, int target, List<List<Integer>> ans, List<Integer> path) {
        if (curr == target) {
            ans.add(new ArrayList<>(path));
        }
        else {
            for (int next : graph.get(curr)) {
                path.add(next);
                backtrack(graph, next, target, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
