class Solution {
    public int largestIsland(int[][] grid) {
        int max = 0;
        int islandId = 2; // grid contains 0 and 1 so we starts at 2 (avoid conflict).
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        
        // key = islandId, value = area of the island.
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId, visited);
                    map.put(islandId, size);
                    islandId++;
                    
                    max = Math.max(max, size);
                }
            }
        }
        
        // loop over all zeroes and see if the neighbour 
        // island combined can make it bigger.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    
                    // set of all neighbour islands that we can add.
                    HashSet<Integer> islandSet = new HashSet<>();
                    for (int d = 0; d < directions.length; d++) {
                        int nx = i + directions[d][0];
                        int ny = j + directions[d][1];
                        
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                            continue;
                        }
                        
                        islandSet.add(grid[nx][ny]);
                    }
                    
                    int sum = 1; // make this 0 to 1.
                    for (int iId : islandSet) {
                        sum = sum + map.get(iId);
                    }
                    
                     max = Math.max(max, sum);
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j, int islandId, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        grid[i][j] = islandId;
        
        return 1 + dfs(grid, i + 1, j, islandId, visited) 
                 + dfs(grid, i - 1, j, islandId, visited)
                 + dfs(grid, i, j + 1, islandId, visited)
                 + dfs(grid, i, j - 1, islandId, visited);
    }
}
