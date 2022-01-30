class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] indegree = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indegree[i] = graph.get(i).size();
            if (indegree[i] == 1) {
                leaves.offer(i);
            }
        }
        
        int count = n;
        while (count > 2) {
            int size = leaves.size();
            count = count - size;
            for (int i = 0; i < size; i++) {
                int curr = leaves.poll();
                for (int next : graph.get(curr)) {
                    indegree[next]--;
                    if (indegree[next] == 1) {
                        leaves.offer(next);
                    }
                }
            }
            
        }
        
        ans.addAll(leaves);
        return ans;
    }
}
