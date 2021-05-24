class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        
        int numRow = mat.length;
        int numCol = mat[0].length;
        int[] ans = new int[numRow * numCol];
        int index = 0;
               
        // there are numRow + numCol - 1 diagonals 
        int numDiags = numRow + numCol - 1;
        for (int i = 0; i < numDiags; i++) {
            
            int row = (i < numCol) ? 0 : (i - numCol + 1);
            int col = (i < numCol) ? i : (numCol - 1);
            
            List<Integer> diagonal = new ArrayList<>();
            
            while (row < numRow && col >= 0) {
                diagonal.add(mat[row][col]);
                row++;
                col--;
            }
            
            //reverse alternate diagonals
            if (i % 2 == 0) {
                Collections.reverse(diagonal);
            }
            
            // add to ans
            for (int num : diagonal) {
                ans[index] = num;
                index++;
            }
        }
        
        return ans;
    }
}
