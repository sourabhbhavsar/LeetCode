class Solution {
    /** When turns is 1, X moved. When turns is 0, O moved. rows stores the number of X or O in each row. cols stores the number of X or O in each column. diag stores the number of X or O in diagonal. antidiag stores the number of X or O in antidiagonal. When any of the value gets to 3, it means X wins. When any of the value gets to -3, it means O wins.

When X wins, O cannot move anymore, so turns must be 1. When O wins, X cannot move anymore, so turns must be 0. Finally, when we return, turns must be either 0 or 1, and X and O cannot win at same time.
**/
    
    public boolean validTicTacToe(String[] board) {
        int turns = 0;
        int[] row = new int[3];
        int[] col = new int[3];
        int diagonal = 0;
        int xDiagonal = 0;
        boolean xWin = false;
        boolean oWin = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                if (board[i].charAt(j) == 'X') {
                    turns++;
                    
                    row[i] = row[i] + 1;
                    col[j] = col[j] + 1;
                    
                    if (i == j) {
                        diagonal = diagonal + 1;
                    }
                    
                    if (i + j == 2) {
                        xDiagonal = xDiagonal + 1;
                    }
                }
                else if (board[i].charAt(j) == 'O') {
                    turns--;
                    
                    row[i] = row[i] - 1;
                    col[j] = col[j] - 1;
                    
                    if (i == j) {
                        diagonal = diagonal - 1;
                    }
                    
                    if (i + j == 2) {
                        xDiagonal = xDiagonal - 1;
                    }
                }
            }
        }
        
        xWin = row[0] == 3 || row[1] == 3 || row[2] == 3 || 
               col[0] == 3 || col[1] == 3 || col[2] == 3 || 
               diagonal == 3 || xDiagonal == 3;
        
        oWin = row[0] == -3 || row[1] == -3 || row[2] == -3 || 
               col[0] == -3 || col[1] == -3 || col[2] == -3 || 
               diagonal == -3 || xDiagonal == -3;
        
        // x can not win when the it is o's turn. 
        // 0 can not win when it is x's turn.
        if ((xWin && turns != 1) || (oWin && turns != 0)) {
            return false;
        }
        
        return turns == 1 || turns == 0;
    }
}
