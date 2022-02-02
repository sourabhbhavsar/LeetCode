class Solution {
    int max = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        int n = values.length;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[] {e[1], e[2]});
            graph.get(e[1]).add(new int[] {e[0], e[2]});
        }
        
        int[] visited = new int[n];
        dfs(graph, n, values, maxTime, 0, 0, 0, visited);
        
        return max;
    }
    
    void dfs(Map<Integer, List<int[]>> graph, int n, int[] values, int maxTime, int curr, int src, int time, int[] visited) {
        if (time > maxTime) {
            return;
        }
        
        if (visited[src] == 0) {
            curr = curr + values[src];
        }
        
        visited[src]++;
        
        if (src == 0) {
            max = Math.max(max, curr);
        }
        
        for (int[] edge : graph.get(src)) {
            int nextTime = edge[1];
            int next = edge[0];
              
            dfs(graph, n, values, maxTime, curr, next, time + nextTime, visited);
        }
        
        visited[src]--;
    }
}
