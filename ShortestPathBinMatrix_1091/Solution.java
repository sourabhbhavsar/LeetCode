class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int [][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        boolean[][] visited = new boolean[m][n];
        
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currx = curr[0];
                int curry = curr[1];
                
                if (currx == m - 1 && curry == n - 1) {
                    return step + 1;
                }
                
                for (int d = 0; d < directions.length; d++) {
                    int nx = currx + directions[d][0];
                    int ny = curry + directions[d][1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
            
            step++;
        }
        
       return -1; 
    }
}
