class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        // [0]->x [1]->y [2]->no of obsatcles removed
        queue.offer(new int[] {0, 0, 0});
        visited[0][0][0] = true;
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if (curr[0] == m - 1 && curr[1] == n - 1) {
                    return step;
                }
                
                for (int d = 0; d < dirs.length; d++) {
                    int nx = curr[0] + dirs[d][0];
                    int ny = curr[1] + dirs[d][1];
                    int countObstacle = curr[2];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (grid[nx][ny] == 1) {
                            countObstacle++;
                        }
                        
                        if (countObstacle <= k && !visited[nx][ny][countObstacle]) {
                            visited[nx][ny][countObstacle] = true;
                            queue.offer(new int[] {nx, ny, countObstacle});
                        }
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
}
