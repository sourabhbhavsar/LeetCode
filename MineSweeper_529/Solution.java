class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null  || click == null || click.length < 2) {
            return board;
        }
        
        int m = board.length;
        int n = board[0].length;
        int x = click[0];
        int y = click[1];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            
            return board;
        }
        else if (board[x][y] == 'E') {
            dfs(board, m, n, x, y, dirs);
        }
        
        return board;
    }
    
    public void dfs(char[][] board, int m, int n, int x, int y, int[][] dirs) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') {
            return;
        }
        
        int mineCount = getAdjacentMineCount(board, m, n, x, y);
        if (mineCount > 0) {
            board[x][y] = (char)('0' + mineCount);
        }
        else {
            board[x][y] = 'B';
            for (int d = 0; d < dirs.length; d++) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                
                dfs(board, m, n, nx, ny, dirs);
            }
        }
        
    }
    
    public int getAdjacentMineCount(char[][] board, int m, int n, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < m && j >=0 && j < n) {
                    if (board[i][j] == 'M') {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
