class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    dfsWalker(grid, i, j, visited);
                }
            }
        }
        
        return count;
    }
    
    public boolean dfsWalker(char[][] grid, int row, int col, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == '0') {
            return false;
        }
        
        visited[row][col] = true;
        
        return dfsWalker(grid, row + 1, col, visited) || dfsWalker(grid, row - 1, col, visited)
               || dfsWalker(grid, row, col + 1, visited) || dfsWalker(grid, row, col - 1, visited);
    }
}
