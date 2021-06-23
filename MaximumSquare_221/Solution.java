class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // longestEdgeEnding[i][j] is the length of the
        // longest edge of the square ending at i, j
        int[][] longestEdgeEnding = new int[m + 1][n + 1];
        
        int longestSquareEdge = 0;
        // skip 0 row and 0 col
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int left = longestEdgeEnding[i][j - 1];
                    int up = longestEdgeEnding[i - 1][j];
                    int leftUp = longestEdgeEnding[i - 1][j - 1];
                    
                    int longestEdgeEndingHere = Math.min(left, Math.min(up, leftUp));
                    // add one for thsi cell.
                    longestEdgeEnding[i][j] = longestEdgeEndingHere + 1;
                    
                    if (longestEdgeEnding[i][j] > longestSquareEdge) {
                        longestSquareEdge = longestEdgeEnding[i][j];
                    }
                        
                }
            }
        }
        
        return longestSquareEdge * longestSquareEdge;
        
    }
}
