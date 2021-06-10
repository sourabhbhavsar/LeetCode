class Solution {
    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int cherries = 0;
        
        // store the results
        Integer[][][][] memo = new Integer[n][n][n][n]; 
        
        // two person starts from 00 and try to reach to n-1 n-1
        // they should reach in same number of steps if a path exist.
        
        cherries = Math.max(cherries, cherryPickupHelper(grid, 0, 0, 0, 0, memo));
        return cherries;
    }
    
    private int cherryPickupHelper(int[][] grid, 
                                   int x1, 
                                   int y1, 
                                   int x2, 
                                   int y2, 
                                   Integer[][][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || x2 < 0 || x2 >= m || y2 < 0 || y2 >= n || grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return Integer.MIN_VALUE;
        }
        
        if (memo[x1][y1][x2][y2] != null) {
            return memo[x1][y1][x2][y2];
        }
        
        int cherries = 0;
        // if the first person is on n -1, n - 1
        // return the value of grid[n - 1][n - 1] could be 0 , could be 1.
        if (x1 == m - 1 && y1 == n - 1) {
            return grid[x1][y1];
        }
        
        // if the second person is on n -1, n - 1
        // return the value of grid[n - 1][n - 1] could be 0 , could be 1.
        if (x2 == m - 1 && y2 == n - 1) {
            return grid[x2][y2];
        }
        
        // if both the persons are on the same cell, do not double count.
        if (x1 == x2 && y1 == y2) {
            cherries = grid[x1][y1]; 
        }
        else {
            cherries = grid[x1][y1] + grid[x2][y2];
        }
        
         // since each person of the 2 person can move only to the bottom or to the right, then the total number of cherries
        // equals the max of the following possibilities:
        //    P1     |      P2
        //   DOWN    |     DOWN
        //   DOWN    |     RIGHT
        //   RIGHT   |     DOWN
        //   RIGHT   |     RIGHT
        
        int cherriesDD = cherryPickupHelper(grid, x1 + 1, y1, x2 + 1, y2, memo);
        int cherriesDR = cherryPickupHelper(grid, x1 + 1, y1, x2, y2 + 1, memo);
        int cherriesRD = cherryPickupHelper(grid, x1, y1 + 1, x2 + 1, y2, memo);
        int cherriesRR = cherryPickupHelper(grid, x1, y1 + 1, x2, y2 + 1, memo);
        
        int maxInFour = Math.max(cherriesDD, Math.max(cherriesDR, Math.max(cherriesRD, cherriesRR)));
        
        cherries = cherries + maxInFour;
        memo[x1][y1][x2][y2] = cherries;
        
        return cherries;
    }

}
