class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
    
            
        Set<int[]> borders = new HashSet<>();
        dfs(grid, m, n, row, col, grid[row][col], visited, borders);
        
        for (int[] xy : borders) {
            grid[xy[0]][xy[1]] = color;
        }
        
        return grid;
    }
    
    void dfs(int[][] grid, int m, int n, int row, int col, int componentColour, boolean[][] visited, Set<int[]> borders) {
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || grid[row][col] != componentColour) {
            return;
        }
        
        visited[row][col] = true;
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1 
            || grid[row + 1][col] != componentColour || grid[row][col + 1] !=  componentColour 
            || grid[row - 1][col] != componentColour || grid[row][col - 1] != componentColour) {
            
            borders.add(new int[]{row, col});
        }
        
        dfs(grid, m, n, row + 1, col, grid[row][col], visited, borders);
        dfs(grid, m, n, row, col + 1, grid[row][col], visited, borders);
        dfs(grid, m, n, row - 1, col, grid[row][col], visited, borders);
        dfs(grid, m, n, row, col - 1, grid[row][col], visited, borders);
    }
}
