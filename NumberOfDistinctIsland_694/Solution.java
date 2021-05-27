class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && visited[i][j] == false) {
                    StringBuilder shape = new StringBuilder("");
                    
                    dfsWalker(grid, i, j, shape, "o", visited); // origin
                    
                    set.add(shape.toString());
                    
                }
            }
        }
        
        System.out.println(set);
        return set.size();
    }
    
    public void dfsWalker(int[][] grid, int i, int j, StringBuilder shape, String direction, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        shape.append(direction);
        
        dfsWalker(grid, i + 1, j, shape, "d", visited);
        dfsWalker(grid, i, j - 1, shape, "l", visited);
        dfsWalker(grid, i, j + 1, shape, "r", visited);
        dfsWalker(grid, i - 1, j, shape, "u", visited);
        shape.append("b"); // back
        
    }
}
