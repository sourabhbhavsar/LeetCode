class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        if (grid == null) {
            return 0;
        }
        
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    int area = getArea(grid, i, j, visited);
                
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    public int getArea(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        
        if (visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        
        return 1 + getArea(grid, i + 1, j, visited) 
                 +  getArea(grid, i, j + 1, visited)
                 +  getArea(grid, i - 1, j, visited) 
                 +  getArea(grid, i, j - 1, visited);
    }
}
