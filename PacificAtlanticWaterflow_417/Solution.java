class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            // Left column is pacific
            if (!pacific[i][0]) {
                dfs(heights, m, n, i, 0, pacific);
            }
            
            // right column is atlantic
            if (!atlantic[i][n - 1]) {
                dfs(heights, m, n, i, n - 1, atlantic);
            }
        }
        
        for (int j = 0; j < n; j++) {
            // top row is pacific
            if (!pacific[0][j]) {
                dfs(heights, m, n, 0, j, pacific);
            }
            
            // bottom row is atlantic
            if (!atlantic[m - 1][j]) {
                dfs(heights, m, n, m - 1, j, atlantic);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
    
    private void dfs(int[][] heights, int m, int n, int x, int y, boolean[][] ocean) {
        ocean[x][y] = true;
        
        for (int d = 0; d < dirs.length; d++) {
            int nx = x + dirs[d][0];
            int ny = y + dirs[d][1];
            
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !ocean[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                dfs(heights, m, n, nx, ny, ocean);
            }
        }
    }
}
