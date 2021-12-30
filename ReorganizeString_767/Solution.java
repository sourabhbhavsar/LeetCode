class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        
        int max = 0;
        char letter = '\0';
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = (char)(i + 'a');
            }
        }
        
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        
        char[] ans = new char[s.length()];
        int index = 0;
        while (hash[letter - 'a'] != 0) {
            ans[index] = letter;
            index = index + 2;
            hash[letter - 'a']--;
        }
        
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (index >= ans.length) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                hash[i]--;
            }
        }
        return String.valueOf(ans);
    }
}
