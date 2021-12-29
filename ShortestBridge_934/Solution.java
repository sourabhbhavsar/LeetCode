class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        boolean found = false;
        
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, m , n, queue, visited);
                    
                    found = true;
                    break;
                }
            }
        }
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int d = 0; d < dirs.length; d++) {
                    int nx = curr[0] + dirs[d][0];
                    int ny = curr[1] + dirs[d][1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == false) {
                        if (grid[nx][ny] == 1) {
                            return step;
                        }
                        
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
    public void dfs(int[][] grid, int i, int j, int m , int n, Queue<int[]> queue, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true || grid[i][j] != 1) {
            return;
        }
        
        visited[i][j] = true;
        queue.offer(new int[] {i, j});
        grid[i][j] = 2;
        dfs(grid, i + 1, j, m , n, queue, visited);
        dfs(grid, i, j + 1, m , n, queue, visited);
        dfs(grid, i - 1, j, m , n, queue, visited);
        dfs(grid, i, j - 1, m , n, queue, visited);
    }
}
