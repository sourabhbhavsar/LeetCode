class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count = count + extendPalindrome(s, i, i); // even length
            count = count + extendPalindrome(s, i, i + 1); // odd length
        }
        
        return count;
    }
    
    public int extendPalindrome(String s, int start, int end) {
        int count = 0;
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            
            // expand
            start--;
            end++;
        }
        
        return count;
    }
   
}
