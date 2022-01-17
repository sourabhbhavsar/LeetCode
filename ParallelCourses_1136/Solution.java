class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n + 1];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
            indegree[i] = 0;
        }
        
        for (int[] r : relations) {
            int pc = r[0];
            int nc = r[1];
            graph.get(pc).add(nc);
            indegree[nc]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int countSemester = 0;
        int numCourses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                numCourses++;
                for (int next : graph.get(curr)) {
                    indegree[next]--;
                
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            countSemester++;
        }
        
        if (numCourses != n) {
            return -1;
        }
        
        return countSemester;
    }
}
