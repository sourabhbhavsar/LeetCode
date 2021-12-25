class NumMatrix {
    Map<Integer, List<Integer>> rowSum;
    
    public NumMatrix(int[][] matrix) {
        rowSum = new HashMap<>();
        
        for (int i = 0; i < matrix.length; i++) {
            int rSum = 0;
            rowSum.put(i, new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                rSum = rSum + matrix[i][j];
                
                rowSum.get(i).add(rSum);
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            int row = rowSum.get(r).get(col2);
            if (col1 > 0) {
                row = row - rowSum.get(r).get(col1 - 1);
            }
            
            sum = sum + row;
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
