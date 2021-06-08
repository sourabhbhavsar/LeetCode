class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] preq : prerequisites) {
            int p = preq[1];
            int c = preq[0];
            
            if (!graph.containsKey(p)) {
                graph.put(p, new ArrayList<>());
            }
            
            graph.get(p).add(c);
            indegree[c]++;
        }
        
        // System.out.println(Arrays.toString(indegree));
        // System.out.println("graph = " + graph);
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            // System.out.println("curr = " + curr);
            
            List<Integer> links = graph.get(curr);
            
            if (links != null) {
                
                for (int l : links) {
                    indegree[l]--;
                
                    if (indegree[l] == 0) {
                        q.add(l);
                    }
                }   
            }
            
            ans.add(curr);
            count++;
        }
        
        if (count != numCourses) {
            return new int[0];
        }
        
        return ans
            .stream()
            .mapToInt(x -> x)
            .toArray();
    }
}
