class Solution {
    public boolean validPalindrome(String s) {
        int l = 0; 
        int r = s.length() - 1;
        
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                // mistamtch
                // at most one permitted
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            }
        }
        
        return true;
    }
    
    public boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
