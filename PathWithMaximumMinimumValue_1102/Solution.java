class Solution {
    public int maximumMinimumPath(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        int score = Integer.MAX_VALUE;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            
            visited[i][j] = true;
            score = Math.min(score, curr[0]);
            
            if (i == m - 1 && j == n - 1) {
                return score;
            }
            
            for (int d = 0; d < directions.length; d++) {
                int nx = i + directions[d][0];
                int ny = j + directions[d][1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[] {grid[nx][ny], nx, ny});
                }
            }
        }
        
        return -1;
    }
}
