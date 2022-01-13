class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        return searchMatrixHelper(matrix, target);
    }
    
    public boolean searchMatrixHelper(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int i  = mid / n;
            int j = (mid) % n;
            
            if (matrix[i][j] <  target) {
                low = mid + 1;
            }
            else if (matrix[i][j] >  target) {
                high = mid - 1;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}
