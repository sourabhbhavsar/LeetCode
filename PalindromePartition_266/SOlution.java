class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int countOdd = 0;
        for (int n : freq) {
            if (n % 2 != 0) {
                countOdd++;
            }
        }
        
        if (countOdd == 1 || countOdd == 0) {
            return true;
        }
        
        return false;
    }
}
