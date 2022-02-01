class Solution {
    public int characterReplacement(String s, int k) {
        int[] charMap = new int[26];
        int max = 0;
        int maxCount = 0;
        int begin = 0;
        int end = 0;
        
        for (end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++charMap[s.charAt(end) - 'A']);
            
            while (end - begin + 1 - maxCount > k) {
                --charMap[s.charAt(begin) - 'A'];
                begin++;
            }
            
            max = Math.max(max, end - begin + 1);
        }
        
        return max;
    }
}
