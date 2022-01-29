class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        // first column
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
                
            }
            else {
                dp[i][0] = 1;
            }
        }
        
         // first row
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
                
            }
            else {
                dp[0][i] = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
        //return helper(obstacleGrid, 0, 0, m, n, dp);
    }
    
    public int helper(int[][] obstacleGrid, int r, int c, int m, int n, int[][] memo) {
        if (r >= m || c >= n) {
            return 0;
        }
        
        if (memo[r][c] > 0) {
            return memo[r][c];
        }
        
        if (r == m - 1 && c == n - 1) {
            if (obstacleGrid[r][c] == 1) {
                 memo[r][c] = 0;
                return 0;
            }
            
            memo[r][c] = 1;
            return 1;
        }
        
        if (obstacleGrid[r][c] == 1) {
            memo[r][c] = 0;
            return 0;
        }
         
        memo[r][c] = helper(obstacleGrid, r + 1, c, m, n, memo) + helper(obstacleGrid, r, c + 1, m, n, memo);
        return memo[r][c];
    }
}
