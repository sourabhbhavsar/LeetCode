class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        Set<Pair<Integer, Integer>> conns = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            rank.put(i, null);
        }
        
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            int m1 = Math.min(u, v);
            int m2 = Math.max(u, v);
            
            conns.add(new Pair<>(m1, m2));
        }
        
        dfs(graph, rank, conns, 0, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        for (Pair<Integer, Integer> edge : conns) {
            ans.add(Arrays.asList(edge.getKey(), edge.getValue()));
        }
        
        return ans;
    }
    
    int dfs( Map<Integer, List<Integer>> graph, Map<Integer, Integer> rank, Set<Pair<Integer, Integer>> conns, int node, int discoveryRank) {
        
        if (rank.get(node) != null) {
            return rank.get(node);
        }
        
        rank.put(node, discoveryRank);
        
        int minRank = Integer.MAX_VALUE;
        
        for (Integer next : graph.get(node)) {
            // skip parent
            if (rank.get(next) != null && rank.get(next) == discoveryRank - 1) {
                continue;
            }
            
            int nextRank = dfs(graph, rank, conns, next, discoveryRank + 1);
            
            if (nextRank <= discoveryRank) {
                int m1 = Math.min(node, next);
                int m2 = Math.max(node, next);
                
                conns.remove(new Pair<>(m1, m2));
            }
            
            minRank = Math.min(minRank, nextRank);
        }
        
        return minRank;
    }
    
}
