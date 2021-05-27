class Solution {
    
    private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0});
        visited.add("0,0");
        
        int ans = 0;
        while (!queue.isEmpty()) {
            int breadth = queue.size();
            
            for (int i = 0; i < breadth; i++) {
                int[] square = queue.poll();
                if (square[0] == x && square[1] == y) {
                    return ans;
                }
                
                // move in all directions and mark them visited.
                for (int d = 0; d < DIRECTIONS.length; d++) {
                    int newX = square[0] + DIRECTIONS[d][0];
                    int newY = square[1] + DIRECTIONS[d][1];
                    
                    if (visited.contains(newX + "," + newY) == false && newX >= -1 && newY >= -1) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                    
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}
