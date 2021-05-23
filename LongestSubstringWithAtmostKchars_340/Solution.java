class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int countDistinct = 0;
        int n = s.length();
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            
            char curr = s.charAt(j);
            if (map.containsKey(curr)) {
                int freq = map.get(curr);
                map.put(curr, freq + 1);
            }
            else {
                map.put(curr, 1);
                countDistinct++;
            }
        
            if (countDistinct <= k) {
                
                int windowSize = j - i + 1;
           
                if (windowSize > maxLength) {
                    maxLength = windowSize;
                }
            }
            else {
                while (countDistinct > k) {
                    char front = s.charAt(i);
                    
                    if (map.containsKey(front)) {
                        int freq = map.get(front);
                        
                        if (freq == 1) {
                            countDistinct--;
                            map.remove(front);
                        }
                        else {
                            map.put(front, freq - 1);
                        }
                    }
                    
                    i++;
                }
            }
        }
        
        return maxLength;
    }
}
