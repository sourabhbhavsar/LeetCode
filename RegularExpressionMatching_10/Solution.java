class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Map<String, Boolean> memo = new HashMap<>();
        
        return isMatch(s, p, m, n, 0, 0, memo);
    }
    
    public boolean isMatch(String s, String p, int m, int n, int i, int j, Map<String, Boolean> memo) {
        if (i >= m && j >= n) {
            return true;
        }
        
        if (j >= n) {
            return false;
        }
        
        String key = i + "_" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // mathteh i and j chars
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        // if the next char in pattern is a *
        if ((j + 1) < n && p.charAt(j + 1) == '*') {
            boolean ans = isMatch(s, p, m, n, i, j + 2, memo) // do no use *, tak it a emoty string ""
                          || match && isMatch(s, p, m, n, i + 1, j, memo); // use * if there was a match with this char
            memo.put(key, ans);
            return ans;
        }
        
        // the next char is not a star, then just match the next char
        if (match) {
            boolean ans = isMatch(s, p, m, n, i + 1, j + 1, memo);
            memo.put(key, ans);
            return ans;
        }
        
        // if this char itself did not match then its not going to match.
        memo.put(key, false);
        return false;
    }
}
