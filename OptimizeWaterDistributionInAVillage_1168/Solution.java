class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        Map<Integer, List<int[]>> graph= new HashMap<>();
        for (int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < wells.length; i++) {
            graph.get(0).add(new int[] {i + 1, wells[i]});
        }
        
        for (int[] pipe : pipes) {
            // BIDIRECTIONAL
            graph.get(pipe[0]).add(new int[] {pipe[1], pipe[2]});
            graph.get(pipe[1]).add(new int[] {pipe[0], pipe[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
                                                        (Integer.compare(a[1], b[1])));
        
        // build a well in one of the house
        for (int[] edge : graph.get(0)) {
            pq.offer(edge);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        int cost = minCostPrims(graph, pq, visited, n);
        return cost;
    }
    
    int minCostPrims(Map<Integer, List<int[]>> graph, PriorityQueue<int[]> pq, Set<Integer> visited, int n) {
        int cost = 0;
        
        while (!pq.isEmpty()) {
            int[] minEdge = pq.poll();
            int currNode = minEdge[0];
            int currCost = minEdge[1];
            
            // Break the processing, if all nodes visited already
            if (visited.size() == n + 1) {
                break;
            }
            
            if (visited.contains(currNode)) {
                continue; // already included
            }
            
            cost = cost + currCost;
            visited.add(currNode);
            
            for (int[] edge : graph.get(currNode)) {
                int nextNode = edge[0];
                if (!visited.contains(nextNode)) {
                    pq.offer(edge);
                }
            }
        }
        
        return cost;
    }
}
