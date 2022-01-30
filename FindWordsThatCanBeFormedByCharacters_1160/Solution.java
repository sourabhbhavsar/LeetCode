class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charMap = new int[26];
        for (char c : chars.toCharArray()) {
            charMap[c - 'a']++;
        }
        
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] mapCopy = Arrays.copyOf(charMap, charMap.length);
            int count = 0;
            for (char curr : word.toCharArray()) {
                if (mapCopy[curr - 'a'] > 0) {
                    mapCopy[curr - 'a']--;
                    count++;
                }
                else {
                    break;
                }
            }
            
            if (count == word.length()) {
                sum = sum + word.length();
            }
        }
        
        return sum;
    }
}
