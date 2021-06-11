class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] c : prerequisites) {
            if (!graph.containsKey(c[1])) {
                graph.put(c[1], new ArrayList<>());
            }
            
            graph.get(c[1]).add(c[0]);
            indegree[c[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            List<Integer> neighbours = graph.get(curr);
            
            if (neighbours != null) {
                for (int neighbour : neighbours) {
                    indegree[neighbour]--;
                
                    if (indegree[neighbour] == 0) {
                        queue.offer(neighbour);
                    }
                }
            }
     
            count++;
        }
        
        return count == numCourses;
    }
}
