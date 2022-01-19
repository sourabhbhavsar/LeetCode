class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        // memo[i][j][diff] means if s1[i:] truncated by <diff> characters if diff > 0 
        // and s2[j:] truncated by <-diff> characters if diff < 0 are equal
        Boolean[][][] memo = new Boolean[l1 + 1][l2 + 1][2000];
        return dfs(0, 0, 0, s1.toCharArray(), s2.toCharArray(), memo);
    }
    
    public boolean dfs(int i, int j , int diff, char[] s1, char[] s2, Boolean[][][] memo){
        if (i == s1.length && j == s2.length && diff == 0) {
            return true;
        }
        
        if (memo[i][j][diff + 1000] != null) {
            return memo[i][j][diff + 1000];
        }
        
        if (i < s1.length && j < s2.length && diff == 0 && s1[i] == s2[j]) {
            if (dfs(i + 1, j + 1, diff, s1, s2, memo)) {
                memo[i][j][diff + 1000] = true;
                return true;
            }
        }
        
        if (i < s1.length && !isDigit(s1[i]) && diff > 0 && dfs(i + 1, j, diff - 1, s1, s2, memo)) {
            memo[i][j][diff + 1000] = true;
            return true;
        }
        
        if (j < s2.length && !isDigit(s2[j]) && diff < 0 && dfs(i, j + 1, diff + 1, s1, s2, memo)) {
            memo[i][j][diff + 1000] = true;
            return true;
        }
        
        int val = 0;
        for (int k = i; k < s1.length && isDigit(s1[k]); k++) {
            val = val * 10 + (s1[k] - '0');
            if (dfs(k + 1, j, diff - val, s1, s2, memo)) {
                memo[i][j][diff + 1000] = true;
                return true;
            }
        }
        
        val = 0;
        for (int k = j; k < s2.length && isDigit(s2[k]); k++) {
            val = val * 10 + (s2[k] - '0');
            if (dfs(i, k + 1, diff + val, s1, s2, memo)) {
                memo[i][j][diff + 1000] = true;
                return true;
            }
        }
        
        memo[i][j][diff + 1000] = false;
        return memo[i][j][diff + 1000];
    }
    
    public boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        
        return false;
    }
}
