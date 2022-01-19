class Solution {
    int max = 0;
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int m = grid.length;
        int n = grid[0].length;
        max = grid[0][0];
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        pq.offer(new int[] {0, 0, grid[0][0]});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            visited[curr[0]][curr[1]] = true;
            max = Math.max(max, curr[2]);
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                break;
            }
            
            for (int d = 0; d < dirs.length; d++) {
                int nx = curr[0] + dirs[d][0];
                int ny = curr[1] + dirs[d][1];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                
                pq.offer(new int[] {nx, ny, grid[nx][ny]});
            }
            
        }
        
        return max;
    }
    
    
}
