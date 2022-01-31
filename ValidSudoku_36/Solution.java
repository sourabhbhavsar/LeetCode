class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char val = board[i][j];
                if (val != '.') {
                    int blockId = ((i / 3) * 3) + (j / 3);
                    
                    if (!set.add("r" + i + "_" + val)) {
                        return false;
                    }
                    
                    if (!set.add("c" + j + "_" + val)) {
                        return false;
                    }
                    
                    if (!set.add("b" + blockId + "_" + val)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    
    public boolean isValidSudoku1(char[][] board) {
       
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) {
                        return false;
                    }
                }
                
                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])) {
                        return false;
                    }
                }
                
                int rowStart = 3 * (i / 3);
                int colStart = 3 * (i % 3);
                    
                if (board[rowStart + j / 3][colStart + j % 3] != '.') {
                    if (!cubeSet.add(board[rowStart + j / 3][colStart + j % 3])) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
