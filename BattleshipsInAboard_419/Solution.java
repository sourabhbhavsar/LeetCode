class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] != '.' && visited[i][j] == false) {
                    count++;
                    
                    dfsBattleship(board, i, j, visited);
                }
                
            }
        }
        
        return count;
    }
    
    public void dfsBattleship(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.' || visited[i][j] == true) {
            return;
        }
        
        visited[i][j] = true;
        
        dfsBattleship(board, i + 1, j, visited);
        dfsBattleship(board, i, j + 1, visited);
        dfsBattleship(board, i - 1, j, visited);
        dfsBattleship(board, i, j - 1, visited);
    }
}
