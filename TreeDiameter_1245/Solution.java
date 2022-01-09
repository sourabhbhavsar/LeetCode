class Solution {
    int diameter = Integer.MIN_VALUE;
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        } 
        
        
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        
        return diameter;
        
    }
    
    public int dfs(List<Integer>[] graph, int node, boolean[] visited) {
        if (visited[node]) {
            return 0;
        }
        
        visited[node] = true;
        int heighestDepth = Integer.MIN_VALUE;
        int secondHeighestDepth = Integer.MIN_VALUE;
        
        for (int child : graph[node]) {
            int depth = dfs(graph, child, visited);
            
            if (depth > heighestDepth) {
                secondHeighestDepth = heighestDepth;
                heighestDepth = depth;
            }
            else if (depth > secondHeighestDepth) {
                secondHeighestDepth = depth;
            }
            
            diameter = Math.max(diameter, heighestDepth + secondHeighestDepth);
        }
        
        return heighestDepth + 1;
    }
}
