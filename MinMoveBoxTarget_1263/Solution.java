class Solution {
    int[][] moves = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int minPushBox(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        int[] box = new int[2];
        int[] storekeeper = new int[2];
        int[] target = new int[2];
        
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                }
                else if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
                else if (grid[i][j] == 'S') {
                    storekeeper[0] = i;
                    storekeeper[1] = j;
                }
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> pushDistMap = new HashMap<>();
        String start = box[0] + "," + box[1] + "," + storekeeper[0] + "," + storekeeper[1];
        // we have not recorded any push yet.
        pushDistMap.put(start, 0);
    
        queue.offer(start);
        int minPushes = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (pushDistMap.get(curr) >= minPushes) {
                continue;
            }
            
            String[] tokens = curr.split(",");
            int[] boxCurr = new int[] {Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1])};
            int[] sCurr = new int[] {Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3])};
            
            // if we have reached the target
            if (boxCurr[0] == target[0] && boxCurr[1] == target[1]) {
                minPushes = Math.min(minPushes, pushDistMap.get(curr));
                // this might not be the minimun and hence keep looking.
                continue;
            }
            
            // move the shopkeeper 1 step.
            for (int[] move : moves) {
                int nsx = sCurr[0] + move[0];
                int nsy = sCurr[1] + move[1];
                
                if (nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#') {
                    continue;
                }
                
                // if shopkeeper meet the box, then the box move in the same direction
                if (nsx == boxCurr[0] && nsy == boxCurr[1]) {
                    int nbx = boxCurr[0] + move[0];
                    int nby = boxCurr[1] + move[1];
                    
                     if (nbx < 0 || nbx >= m || nby < 0 || nby >= n || grid[nbx][nby] == '#') {
                        continue;
                    }
                    
                    String newPosition = nbx + "," + nby + "," + nsx + "," + nsy;
                    
                    if (pushDistMap.containsKey(newPosition) && pushDistMap.get(newPosition) <= pushDistMap.get(curr) + 1) {
                        continue;
                    }
                    
                    pushDistMap.put(newPosition, pushDistMap.get(curr) + 1);
                    queue.offer(newPosition);
                }
                // if the storekeeper doesn't meet the box, the position of the box do not change
                else {
                    String newPosition = boxCurr[0] + "," + boxCurr[1] + "," + nsx + "," + nsy;
                    if (pushDistMap.containsKey(newPosition) && pushDistMap.get(newPosition) <= pushDistMap.get(curr)) {
                        continue;
                    }
                    pushDistMap.put(newPosition, pushDistMap.get(curr));
                    queue.offer(newPosition);
                }
            }
        }
        
        return minPushes == Integer.MAX_VALUE ? -1 : minPushes;
        
    }
}
