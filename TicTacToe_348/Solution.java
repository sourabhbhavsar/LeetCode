class TicTacToe {

    int[] rowSum;
    int [] colSum;
    int diagonal;
    int antiDiagonal;
    int size;
    
    public TicTacToe(int n) {
        rowSum = new int[n];
        colSum = new int[n];
        size = n;
        
        diagonal = 0;
        antiDiagonal = 0;
    }
    
    public int move(int row, int col, int player) {
        int toAdd = (player == 1) ? 1 : -1;
        
        rowSum[row] = rowSum[row] + toAdd;
        colSum[col] = colSum[col] + toAdd;
        
        if (row == col) {
            diagonal = diagonal + toAdd;
        }
        
        if (row + col == (size - 1)) {
            antiDiagonal = antiDiagonal + toAdd;
        }
        
        if (Math.abs(rowSum[row]) == size ||
            Math.abs(colSum[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(antiDiagonal) == size) {
            
            return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
