class Solution {
    public int numSquares(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                for (int j = 1; j * j <= n; j++) {
                    int next = curr + j * j;
                    if (next == n) {
                        return step;
                    }
                    else if (next > n) {
                        break;
                    }
                    
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
}
