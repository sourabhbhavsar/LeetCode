class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] directions = new int[4][2];
        int numRow = grid.length;
        int numCol = grid[0].length;
        
        int sidesCount = 0;
        
        directions[0] = new int[]{0, 1}; // right
        directions[1] = new int[]{0, -1}; // left 
        directions[2] = new int[]{-1, 0}; // up
        directions[3] = new int[]{1, 0}; // down
        
        
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                
                // if it is an island
                if (grid[i][j] == 1) {
                    
                    // count how many sides in the 4 direction are zero or are out of bounds
                    for (int d = 0; d < directions.length; d++) {
                        int r = i + directions[d][0];
                        int c = j + directions[d][1];
                        
                        if (r < 0 || r >= numRow || c < 0 || c >= numCol || grid[r][c] == 0) {
                            sidesCount++;
                        }
                    }
                    
                }
            }
        }
        
        return sidesCount;
    }
}
