class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (true) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            
            for (int j = right; j >= left; j--) {
                ans.add(matrix[bottom][j]);
            }
            bottom--;
            if (top > bottom || left > right) {
                break;
            }
            
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (top > bottom || left > right) {
                break;
            }
            
        }
        
        return ans;
    }
}
