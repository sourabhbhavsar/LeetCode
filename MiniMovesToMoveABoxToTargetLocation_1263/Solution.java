class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][][] visited = new boolean[m][n][4];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        Queue<int[]> playerQueue = new LinkedList<>();
        Queue<int[]> boxQueue = new LinkedList<>();
        int[] target = new int[2];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    boxQueue.offer(new int[] {i, j});
                }
                if (grid[i][j] == 'S') {
                    playerQueue.offer(new int[] {i, j});
                }
                if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
        
        int step = 0;
        while (!boxQueue.isEmpty()) {
            int size = boxQueue.size();
            for (int i = 0; i < size; i++) {
                int[] box = boxQueue.poll();
                int[] player = playerQueue.poll();
                
                if (box[0] == target[0] && box[1] == target[1]) {
                    return step;
                }
                
                for (int d = 0; d < 4; d++) {
                    if (visited[box[0]][box[1]][d]) {
                        continue;
                    }
                    
                    int[] dir = dirs[d];
                    // player is a step behind from box
                    int nPlayerX = box[0] - dir[0];
                    int nPlayerY = box[1] - dir[1];
                    if (nPlayerX < 0 || nPlayerX >= m || nPlayerY < 0 || nPlayerY >= n || grid[nPlayerX][nPlayerY] == '#') {
                        continue;
                    }
                    
                    int nBoxX = box[0] + dir[0];
                    int nBoxY = box[1] + dir[1];
                    if (nBoxX < 0 || nBoxX >= m || nBoxY < 0 || nBoxY >= n || grid[nBoxX][nBoxY] == '#') {
                        continue;
                    }
                    
                    if (!reachable(grid, nPlayerX, nPlayerY, box, player)) {
                        continue;
                    }
                    
                    visited[box[0]][box[1]][d] = true;
                    boxQueue.offer(new int[] {nBoxX, nBoxY});
                    playerQueue.offer(new int[] {nPlayerX, nPlayerY});
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
    private boolean reachable(char[][] grid, int targetX, int targetY, int[] box, int[] player) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(player);
        boolean[][] visited = new boolean[m][n];
        visited[box[0]][box[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == targetX && curr[1] == targetY) {
                return true;
            }
            
            for (int[] dir : dirs) {
                int nX = curr[0] + dir[0];
                int nY = curr[1] + dir[1];
                
                if (nX < 0 || nX >= m || nY < 0 || nY >= n || visited[nX][nY] || grid[nX][nY] == '#') {
                    continue;
                }
                
                queue.offer(new int[] {nX, nY});
                visited[nX][nY] = true;
            }
        }
        
        return false;
    }
}
