class Solution {
    public int expressiveWords(String s, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        
        int count = 0;
        for (String word: words) {
            if (isStretchy(word, s)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isStretchy(String word, String s) {
        if (word == null) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedCharLen(s, i);
                int len2 = getRepeatedCharLen(word, j);
                
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                
                i = i + len1;
                j = j + len2;
            }
            else {
                return false;
            }
        }
        
        return i == s.length() && j == word.length();
    }
    
    private int getRepeatedCharLen(String s, int i) {
        int j = i;
        while (j < s.length() && s.charAt(j) == s.charAt(i)) {
            j++;
        }
        
        return j - i;
    }
}
