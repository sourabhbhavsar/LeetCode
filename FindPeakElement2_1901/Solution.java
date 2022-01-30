class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int startCol = 0;
        int endCol = mat[0].length - 1;
        
        while (startCol <= endCol) {
            int midCol = (startCol + endCol) / 2;
            
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] >= mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            int curr = mat[maxRow][midCol];
            int left = (midCol == 0) ? -1 : (mat[maxRow][midCol - 1]);
            int right = (midCol == n - 1) ? -1 : (mat[maxRow][midCol + 1]);
            
            if (curr > left && curr > right) {
                return new int[] {maxRow, midCol};
            }
            else if (right > curr) {
                startCol = midCol + 1;
            }
            else {
                endCol = midCol - 1;
            }
        }
        
        return new int[] {-1, -1};
    }
}
