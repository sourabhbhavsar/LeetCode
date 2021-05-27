class Solution {
    public String tictactoe(int[][] moves) {
        int[] row = new int[3];
        int[] col = new int[3];
        int diagonal = 0;
        int xDiagonal = 0;
        String turn = "A";
        
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                turn = "A";
                row[moves[i][0]]++;
                col[moves[i][1]]++;
                
                if (moves[i][0] == moves[i][1]) {
                    diagonal++;
                }
                
                if (moves[i][0] + moves[i][1] == 2) {
                    xDiagonal++;
                }
            }
            else {
                turn = "B";
                
                row[moves[i][0]]--;
                col[moves[i][1]]--;
                
                if (moves[i][0] == moves[i][1]) {
                    diagonal--;
                }
                
                if (moves[i][0] + moves[i][1] == 2) {
                    xDiagonal--;
                }
            }
            
            if (row[0] == 3 || row[1] == 3 || row[2] == 3 || 
                col[0] == 3 || col[1] == 3 || col[2] == 3 ||
                diagonal == 3 || xDiagonal == 3) {
                return "A";
            }
            
            if (row[0] == -3 || row[1] == -3 || row[2] == -3 || 
                col[0] == -3 || col[1] == -3 || col[2] == -3 ||
                diagonal == -3 || xDiagonal == -3) {
                return "B";
            }
            
        }
        
        if (moves.length == 9) {
            return "Draw";
        }
        
        return "Pending";
    }
}
