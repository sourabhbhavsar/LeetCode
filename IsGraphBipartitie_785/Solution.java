class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        } 
        
        int m = graph.length;
        int n = graph[0].length;
        int[] colours = new int[m];
        
        for (int i = 0; i < m; i++) { // need to do BFS n each node as the graph could be disconnected.
            if (colours[i] != 0) {
                continue; // skip if already visited.
            }
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colours[i] = 1;
        
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int[] neighbours = graph[curr];
                for (int neighbour : neighbours) {
                    if (colours[neighbour] == 0) {
                        colours[neighbour] = -colours[curr];
                        queue.offer(neighbour);
                    }
                    else {
                        if (colours[neighbour] !=  -colours[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
