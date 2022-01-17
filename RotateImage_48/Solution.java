class Solution {
    /*
 * clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each row
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  => 2 5 8  => 8 5 2
 * 7 8 9     3 6 9     9 6 3
 * 
 * anti-clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each col
*/
    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        
        for (int row = 0; row < matrix.length; row++) {
            int i = 0;
            int j = matrix[row].length - 1;
            
            while (i < j) {
                int t = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = t;
                i++;
                j--;
            }
        }
    }
    
    void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
