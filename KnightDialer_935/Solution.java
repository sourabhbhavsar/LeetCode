class Solution {
    public static final int mod = (int) Math.pow(10, 9) + 7;

    int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; 
    public int knightDialer(int n) {
        long count = 0;
        Map<String, Long> memo = new HashMap<>();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                count = (count + knightDialerHelper(i, j, n, memo)) % mod;
            }
        }
        
        return (int) count;
    }
    
    /*
            1   2   3
            4   5   6
            7   8   9
            *   0   *
    
    */
    public long knightDialerHelper(int i, int j, int n, Map<String, Long> memo) {
        // if the knight hops outside of the matrix or to * return 0 
        //as there are no unique paths from here
        if (i < 0 || i >= 4 || j < 0 || j >= 3 || (i == 3 && j != 1)) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        String key = i + "_" + j + "_" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        long ans = 0;
        
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            
            ans = (ans + knightDialerHelper(nx, ny, n - 1, memo)) % mod;
        }
        
        memo.put(key, ans);
        return ans;
    }
}
