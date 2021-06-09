class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    int[] gate = new int[] {i, j};
                    q.add(gate);
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < directions.length; d++) {
                int currx = curr[0];
                int curry = curr[1];
                int nx = currx + directions[d][0];
                int ny = curry + directions[d][1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (rooms[nx][ny] == Integer.MAX_VALUE) {
                        rooms[nx][ny] = Math.min(rooms[nx][ny], rooms[currx][curry] + 1);
                        q.add(new int[]{nx, ny});
                    }
                }
            }  
        }
    }
}
