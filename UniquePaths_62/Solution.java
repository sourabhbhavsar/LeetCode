class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePathsDP(m - 1, n - 1, memo);
    }
    
    public int uniquePathsDP(int r, int c, int[][] memo) {
        if (r < 0 || c < 0) {
            return 0;
        }        

        if (memo[r][c] > 0) {
            return memo[r][c];
        }
        
        if (r == 0 && c == 0) {
            return 1;
        }
    
        memo[r][c] = uniquePathsDP(r - 1, c, memo) + uniquePathsDP(r, c - 1, memo);
        return memo[r][c];
    }
}
