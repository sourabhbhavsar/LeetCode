class Solution {
    public boolean isValidPalindrome(String s, int k) {
        Map<String, Integer> memo = new HashMap<>();
        int min = getMinRemovalPalindrome(s, 0, s.length() - 1, memo);
        if (min <= k) {
            return true;
        }
        
        return false;
    }
    
    int getMinRemovalPalindrome(String s, int start, int end, Map<String, Integer> memo) {
        if (start >= end) {
            return 0;
        }
        
        String key = start + "_" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int minRemoval = 0;
        if (s.charAt(start) == s.charAt(end)) {
            minRemoval = getMinRemovalPalindrome(s, start + 1, end - 1, memo);
        }
        else {
            int left = 1 + getMinRemovalPalindrome(s, start + 1, end, memo);
            int right = 1 + getMinRemovalPalindrome(s, start, end - 1, memo);
            minRemoval = Math.min(left, right);
        }
        
        memo.put(key, minRemoval);
        return minRemoval;
    }
}
