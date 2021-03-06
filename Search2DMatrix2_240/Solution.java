class Solution {
    // Time complexity : O(n+m)\mathcal{O}(n+m)O(n+m)
    // Space complexity : O(1)\mathcal{O}(1)O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = n - 1;
        
        while (i >= 0 && i < m && j >= 0 && j < n) {
            if (matrix[i][j] > target) {
                j--;
            }
            else if (matrix[i][j] < target) {
                i++;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}
