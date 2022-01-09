class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] buildingsReachable = new int[m][n];
        int numBuildings = 0;
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, m, n, i , j, distance, buildingsReachable);
                    numBuildings++;
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {    
                if (grid[i][j] == 0 && buildingsReachable[i][j] == numBuildings) {
                    shortest = Math.min(shortest, distance[i][j]);   
                }
            }
        }
        
        if (shortest == Integer.MAX_VALUE) {
            shortest = -1;
        }
        
        return shortest;
    }
    
    public void bfs(int[][] grid, 
                    int m, 
                    int n, 
                    int i, 
                    int j, 
                    int[][]distance, 
                    int[][] buildingsReachable) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        queue.offer(new int[] {i, j});
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                for (int d = 0; d < dirs.length; d++) {
                    int nx = curr[0] + dirs[d][0];
                    int ny = curr[1] + dirs[d][1];
                
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n 
                        && !visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[nx][ny] + level;
                        buildingsReachable[nx][ny]++;
                        
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
            
            level++;
        }
    }
}
