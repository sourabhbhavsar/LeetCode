class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        backtrack(board, 0, ans);
        
        return ans;
    }
    
    void  backtrack(char[][] board, int col, List<List<String>> ans) {
        if (col == board.length) {
            ans.add(stringify(board));
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col + 1, ans);
                board[i][col] = '.';
            }
        }
    }
    
    
    public boolean isValid(char[][] board, int row, int col) {
        
        /* Check this row on left side */
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        
        /* Check the upper diagonal */
        for (int i = row, j = col; i >=0 && j >= 0; j--, i--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        /* Check the lower diagonal from left side*/
        for (int i = row, j = col; i < board.length && j >= 0; j--, i++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> stringify(char[][] board) {
        List<String> out = new ArrayList<>();
        for (char[] row : board) {
            out.add(new String(row));
        }
        
        return out;
    }
}
